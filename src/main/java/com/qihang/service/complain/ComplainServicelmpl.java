package com.qihang.service.complain;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.complaint.admin.dto.complaintDTO;
import com.qihang.controller.complaint.admin.dto.complaintreplyDTO;
import com.qihang.controller.complaint.admin.vo.ComplaintVO;
import com.qihang.domain.complaint.ComplaintDO;
import com.qihang.domain.user.SysUserDO;
import com.qihang.mapper.complaint.ComplaintMapper;
import com.qihang.mapper.user.SysUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ComplainServicelmpl extends ServiceImpl<ComplaintMapper, ComplaintDO> implements IComplainService {
    @Resource
    private ComplaintMapper complaintMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public CommonListVO<ComplaintVO> List()
    {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        int userid = Integer.parseInt(servletRequestAttributes.getRequest().getHeader("X-User"));

        SysUserDO sysUserDO = sysUserMapper.selectOne(new QueryWrapper<SysUserDO>().lambda().eq(SysUserDO::getId,userid));
        //超级管理员显示平台数据
        if (sysUserDO.getRoleName().equals("超级管理员") && sysUserDO.getRoleId() == 2) {
            CommonListVO<ComplaintVO> commonList = new CommonListVO<>();
            List<ComplaintDO> textList = complaintMapper.selectList(new QueryWrapper<ComplaintDO>().lambda());
            List<ComplaintVO> list = BeanUtil.copyToList(textList, ComplaintVO.class);
            commonList.setVoList(list);
            return commonList;
        }else{
            ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            int tid = Integer.parseInt(servletRequestAttribute.getRequest().getHeader("X-Tenant-Id"));

            CommonListVO<ComplaintVO> commonList = new CommonListVO<>();
            List<ComplaintDO> textList = complaintMapper.selectList(new QueryWrapper<ComplaintDO>().lambda().eq(ComplaintDO::getUserid,tid));
            List<ComplaintVO> list = BeanUtil.copyToList(textList, ComplaintVO.class);
            commonList.setVoList(list);
            return commonList;
        }
    }
    @Override
    public CommonListVO<ComplaintVO> Listhome(complaintDTO complaintdto)
    {

        CommonListVO<ComplaintVO> commonList = new CommonListVO<>();
        List<ComplaintDO> textList = complaintMapper.selectList(new QueryWrapper<ComplaintDO>().lambda().eq(ComplaintDO::getUserid,complaintdto.getUserid()));

        List<ComplaintVO> list = BeanUtil.copyToList(textList, ComplaintVO.class);
        commonList.setVoList(list);
        return commonList;
    }
    @Override
    public BaseVO add(complaintDTO complaintAdd) {


        ComplaintDO complaintmodel = new ComplaintDO();
        complaintmodel.setPhone(complaintAdd.getPhone());
        complaintmodel.setDescriptor(complaintAdd.getDescriptor());
        complaintmodel.setType(complaintAdd.getType());
        complaintmodel.setPic(complaintAdd.getPic());
        complaintmodel.setCreateTime(new Date());
        complaintmodel.setUpdateTime(new Date());
        complaintmodel.setUserid(complaintAdd.getUserid());
        complaintMapper.insert(complaintmodel);
        return new BaseVO();
    }
    @Override
    public BaseVO reply(complaintreplyDTO complaintAdd) {


        ComplaintDO complaintmodel = complaintMapper.selectById(complaintAdd.getId());

        complaintmodel.setReply(complaintAdd.getReply());

        complaintMapper.updateById(complaintmodel);
        return new BaseVO();
    }
    @Override
    public BaseVO delete(Integer id) {
        complaintMapper.deleteById(id);
        return new BaseVO();
    }




}
