package com.qihang.service.role;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.role.admin.dto.addroleDTO;
import com.qihang.controller.role.admin.dto.roleDTO;
import com.qihang.controller.role.admin.vo.permissionsVO;
import com.qihang.controller.role.admin.vo.roleVO;
import com.qihang.domain.permissions.permissionsDO;
import com.qihang.domain.role.RoleDO;
import com.qihang.mapper.permissions.permissionsMapper;
import com.qihang.mapper.role.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class RoleServicelmpl  extends ServiceImpl<RoleMapper, RoleDO> implements IRoleService {
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private permissionsMapper PermissionsMapper;
    @Override
    public CommonListVO<roleVO> List(roleDTO role) {
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        int tid = Integer.parseInt(servletRequestAttributes.getRequest().getHeader("X-Tenant-Id"));

        CommonListVO<roleVO> commonList = new CommonListVO<>();
        //分页
        Page<RoleDO> page = new Page<>(role.getPageNo(), role.getPageSize());
        LambdaQueryWrapper<RoleDO> qw = new QueryWrapper<RoleDO>().lambda();
        qw.like(StrUtil.isNotBlank(role.getName()), RoleDO::getName, role.getName());
        Page<RoleDO> pageData = roleMapper.selectPage(page, qw);
        List<RoleDO> list = pageData.getRecords();
        List<roleVO> shopList = BeanUtil.copyToList(list, roleVO.class);

        for (roleVO RoleVO : shopList) {
            List<permissionsVO> RList = new ArrayList<>();
            List<permissionsDO> sysList = PermissionsMapper.selectList(new QueryWrapper<permissionsDO>().lambda().eq(permissionsDO::getName, RoleVO.getName()));
            for (permissionsDO permissions : sysList) {
                permissionsVO permissionsvo=new permissionsVO();
                permissionsvo.setId(permissions.getId());
                permissionsvo.setName(permissions.getName());
                permissionsvo.setRolePaths(permissions.getRolePaths());
                permissionsvo.setRolePermissionName(permissions.getRolePermissionName());
                permissionsvo.setRoleGroups(permissions.getRoleGroups());
                permissionsvo.setRoleCheckeds(permissions.getRoleCheckeds());
                permissionsvo.setRoleTitle(permissions.getRoleTitle());
                RList.add(permissionsvo);
            }
            RoleVO.setPermissionsList(RList);
        }



        commonList.setVoList(shopList);
        commonList.setTotal(pageData.getTotal());
        return commonList;
    }
    @Override
    public BaseVO add(addroleDTO role) {
        RoleDO adminrole = new RoleDO();
       adminrole.setName(role.getName());
       adminrole.setDescribes(role.getDescribes());
       adminrole.setRoleStatus(role.getRoleStatus());
        int aaa = roleMapper.insert(adminrole);
        // 获取最新的 id
//        System.out.println("最新插入的记录的 id：" + adminrole.getId());

        List<permissionsVO> permissionsList = role.getPermissionsList();
        for (permissionsVO permissionsVO : permissionsList) {
            permissionsDO permissionsdo=new permissionsDO();
            permissionsdo.setName(role.getName());
            permissionsdo.setRoleGroups(permissionsVO.getRoleGroups());
            permissionsdo.setRolePaths(permissionsVO.getRolePaths());
            permissionsdo.setRoleCheckeds(permissionsVO.getRoleCheckeds());
            permissionsdo.setRolePermissionName(permissionsVO.getRolePermissionName());
            permissionsdo.setRoleTitle(permissionsVO.getRoleTitle());
            permissionsdo.setRoleId(adminrole.getId());
            PermissionsMapper.insert(permissionsdo);
        }

        return new BaseVO();
    }

    @Override
    public BaseVO edit(addroleDTO role) {
        RoleDO adminrole = roleMapper.selectOne(new QueryWrapper<RoleDO>().lambda().eq(RoleDO::getId, role.getId()));
        List<permissionsVO> permissionsList = role.getPermissionsList();
        List<permissionsDO> existingPermissions = PermissionsMapper.selectList(new QueryWrapper<permissionsDO>().lambda().eq(permissionsDO::getName, adminrole.getName()));

        // 更新权限数据
        for (permissionsVO permissionsVO : permissionsList) {
            boolean found = false;
            for (permissionsDO existingPermission : existingPermissions) {
                if (permissionsVO.getRolePermissionName().equals(existingPermission.getRolePermissionName())) {
                    // 更新子表的roleCheckeds为1
                    existingPermission.setRoleCheckeds(1);
                    PermissionsMapper.updateById(existingPermission);
                    found = true;
                    break;
                }
            }
            if (!found) {
                permissionsDO newPermission = new permissionsDO();
                newPermission.setName(adminrole.getName());
                newPermission.setRoleGroups(permissionsVO.getRoleGroups());
                newPermission.setRolePaths(permissionsVO.getRolePaths());
                newPermission.setRoleCheckeds(1); // 新增的权限设置为1
                newPermission.setRolePermissionName(permissionsVO.getRolePermissionName());
                newPermission.setRoleTitle(permissionsVO.getRoleTitle());
                PermissionsMapper.updateById(newPermission);
            }
        }

        // 将未找到的权限设置为0
        for (permissionsDO existingPermission : existingPermissions) {
            boolean found = false;
            for (permissionsVO permissionsVO : permissionsList) {
                if (permissionsVO.getRolePermissionName().equals(existingPermission.getRolePermissionName())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                existingPermission.setRoleCheckeds(0);
                PermissionsMapper.updateById(existingPermission);
            }
        }

        adminrole.setName(role.getName());
        roleMapper.updateById(adminrole);
        return new BaseVO();
    }


    @Override
    public BaseVO delete(Integer id) {
        roleMapper.deleteById(id);
        List<permissionsDO> permissions = PermissionsMapper.selectList(new QueryWrapper<permissionsDO>().lambda().eq(permissionsDO::getRoleId,id));
        for (permissionsDO permissionss : permissions) {
            PermissionsMapper.delete(new QueryWrapper<permissionsDO>().lambda().eq(permissionsDO::getId,permissionss.getId()));
        }
        return new BaseVO();
    }
}
