package com.qihang.service.notice;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.notice.admin.dto.NoticeDTO;
import com.qihang.controller.notice.admin.vo.NoticeQueryVO;
import com.qihang.controller.notice.app.vo.NoticeVO;
import com.qihang.domain.notice.NoticeDO;
import com.qihang.domain.user.SysUserDO;
import com.qihang.mapper.notice.NoticeMapper;
import com.qihang.mapper.user.SysUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author qihang
 * @since 2022-10-08
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, NoticeDO> implements INoticeService {
    @Resource
    private NoticeMapper noticeMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public CommonListVO<NoticeQueryVO> adminList(NoticeDTO noticeShop) {

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        int userid = Integer.parseInt(servletRequestAttributes.getRequest().getHeader("X-User"));

        SysUserDO sysUserDO = sysUserMapper.selectOne(new QueryWrapper<SysUserDO>().lambda().eq(SysUserDO::getId,userid));
        //超级管理员显示平台数据
        if (sysUserDO.getRoleName().equals("超级管理员") && sysUserDO.getRoleId() == 2) {
            CommonListVO<NoticeQueryVO> commonList = new CommonListVO<>();
            Page<NoticeDO> page = new Page<>(noticeShop.getPageNo(), noticeShop.getPageSize());
            LambdaQueryWrapper<NoticeDO> qw = new QueryWrapper<NoticeDO>().lambda();
            Date startTime = null;
            Date endTime = null;
            if (ObjectUtil.isNotNull(noticeShop.getStartTime())) {
                startTime = DateUtil.parse(new SimpleDateFormat("yyyy-MM-dd").format(noticeShop.getStartTime()) + " 00:00:00");
                qw.ge(NoticeDO::getCreateTime, startTime);
            }
            if (ObjectUtil.isNotNull(noticeShop.getEndTime())) {
                endTime = DateUtil.parse(new SimpleDateFormat("yyyy-MM-dd").format(noticeShop.getEndTime()) + " 23:59:59");
                qw.le(NoticeDO::getCreateTime, endTime);
            }
            qw.orderByDesc(NoticeDO::getCreateTime);
            Page<NoticeDO> pageData = noticeMapper.selectPage(page, qw);
            List<NoticeDO> list = pageData.getRecords();
            List<NoticeQueryVO> List = BeanUtil.copyToList(list, NoticeQueryVO.class);
            commonList.setVoList(List);
            commonList.setTotal(pageData.getTotal());
            return commonList;

        } else {
            ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            int tid = Integer.parseInt(servletRequestAttribute.getRequest().getHeader("X-Tenant-Id"));

            CommonListVO<NoticeQueryVO> commonList = new CommonListVO<>();
            Page<NoticeDO> page = new Page<>(noticeShop.getPageNo(), noticeShop.getPageSize());
            LambdaQueryWrapper<NoticeDO> qw = new QueryWrapper<NoticeDO>().lambda().eq(NoticeDO::getTenantId,tid);
            Date startTime = null;
            Date endTime = null;
            if (ObjectUtil.isNotNull(noticeShop.getStartTime())) {
                startTime = DateUtil.parse(new SimpleDateFormat("yyyy-MM-dd").format(noticeShop.getStartTime()) + " 00:00:00");
                qw.ge(NoticeDO::getCreateTime, startTime);
            }
            if (ObjectUtil.isNotNull(noticeShop.getEndTime())) {
                endTime = DateUtil.parse(new SimpleDateFormat("yyyy-MM-dd").format(noticeShop.getEndTime()) + " 23:59:59");
                qw.le(NoticeDO::getCreateTime, endTime);
            }
            qw.orderByDesc(NoticeDO::getCreateTime);
            Page<NoticeDO> pageData = noticeMapper.selectPage(page, qw);
            List<NoticeDO> list = pageData.getRecords();
            List<NoticeQueryVO> List = BeanUtil.copyToList(list, NoticeQueryVO.class);
            commonList.setVoList(List);
            commonList.setTotal(pageData.getTotal());
            return commonList;

        }
    }


    @Override
    public BaseVO add(NoticeDTO notice) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        int tid = Integer.parseInt(servletRequestAttributes.getRequest().getHeader("X-Tenant-Id"));

        NoticeDO noticeDO = new NoticeDO();
        noticeDO.setMsg(notice.getMsg());
        noticeDO.setTenantId(tid);

        noticeMapper.insert(noticeDO);
        return new BaseVO();
    }


    @Override
    public CommonListVO<NoticeVO> List(com.qihang.controller.notice.app.dto.@Valid NoticeDTO notice) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        int tid = Integer.parseInt(servletRequestAttributes.getRequest().getHeader("X-Tenant-Id"));

        CommonListVO<NoticeVO> commonList = new CommonListVO<>();
        List<NoticeDO> noticeDOList = noticeMapper.selectList(new QueryWrapper<NoticeDO>().lambda().eq(NoticeDO::getTenantId,tid));
        List<NoticeVO> list = BeanUtil.copyToList(noticeDOList, NoticeVO.class);
        commonList.setVoList(list);
        return commonList;


    }
}


