package com.qihang.controller.role.admin;

import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.role.admin.dto.addroleDTO;
import com.qihang.controller.role.admin.dto.roleDTO;
import com.qihang.controller.role.admin.vo.roleVO;
import com.qihang.service.role.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/admin/role")
public class RoleController {
    @Resource
    private IRoleService RoleService;
    @PostMapping("/list")
    @ApiOperation("列表接口")
    public CommonListVO<roleVO> list(@RequestBody @Valid roleDTO role) {
        return RoleService.List(role);
    }
    @PostMapping("/add")
    @ApiOperation("添加")
    public BaseVO add(@RequestBody @Valid addroleDTO role) {
        return RoleService.add(role);
    }
    @PostMapping("/edit")
    @ApiOperation("编辑")
    public BaseVO edit(@RequestBody @Valid addroleDTO role) {
        return RoleService.edit(role);
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    public BaseVO delete(@PathVariable("id") Integer id) {
        return RoleService.delete(id);
    }

}
