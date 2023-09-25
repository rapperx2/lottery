package com.qihang.service.homepage;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.Homepage.admin.dto.homepageDTO;
import com.qihang.controller.Homepage.admin.vo.homepageVO;
import com.qihang.domain.homepage.homepageDO;
import com.qihang.mapper.homepage.HomepageMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomepageServicelmpl extends ServiceImpl<HomepageMapper, homepageDO> implements IHomepageService {
    @Resource
    private HomepageMapper homepageMapper;

    @Override
    public CommonListVO<homepageVO> List(homepageDTO adminHome) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        int tid = Integer.parseInt(servletRequestAttributes.getRequest().getHeader("X-Tenant-Id"));

        CommonListVO<homepageVO> commonList = new CommonListVO<>();
        //分页
        Page<homepageDO> page = new Page<>(adminHome.getPageNo(), adminHome.getPageSize());
        LambdaQueryWrapper<homepageDO> qw = new QueryWrapper<homepageDO>().lambda();
        qw.like(StrUtil.isNotBlank(adminHome.getTitle()), homepageDO::getTitle, adminHome.getTitle());
        if (adminHome.getTid() != null && adminHome.getTid() > 0) {
            qw.eq(homepageDO::getTid, adminHome.getTid());
        }else{
            qw.eq(homepageDO::getTid, tid);
        }
        qw.orderByDesc(homepageDO::getId);
        Page<homepageDO> pageData = homepageMapper.selectPage(page, qw);
        List<homepageDO> list = pageData.getRecords();
        List<homepageVO> homeList = BeanUtil.copyToList(list, homepageVO.class);


        commonList.setVoList(homeList);
        commonList.setTotal(pageData.getTotal());
        return commonList;
    }
    @Override
    public BaseVO add(homepageDTO adminHome) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        int tid = Integer.parseInt(servletRequestAttributes.getRequest().getHeader("X-Tenant-Id"));
       homepageDO homedo=new homepageDO();
       homedo.setTitle(adminHome.getTitle());
       homedo.setPic(adminHome.getPic());
        if (adminHome.getTid() != null && adminHome.getTid() > 0) {
            homedo.setTid(adminHome.getTid());
        }else {
            homedo.setTid(tid);
        }

       homedo.setDescribea(adminHome.getDescribea());
       homepageMapper.insert(homedo);
        return new BaseVO();
    }
    @Override
    public BaseVO update(homepageDTO adminHome) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        int tid = Integer.parseInt(servletRequestAttributes.getRequest().getHeader("X-Tenant-Id"));
        homepageDO homedo=homepageMapper.selectOne(new QueryWrapper<homepageDO>().lambda().eq(homepageDO::getId, adminHome.getId()));
        homedo.setTitle(adminHome.getTitle());
        homedo.setPic(adminHome.getPic());
        if (adminHome.getTid() != null && adminHome.getTid() > 0) {
            homedo.setTid(adminHome.getTid());
        }else {
            homedo.setTid(tid);
        }
        homedo.setTid(adminHome.getTid());
        homedo.setDescribea(adminHome.getDescribea());
        homepageMapper.updateById(homedo);
        return new BaseVO();
    }
    @Override
    public BaseVO delete(Integer id) {
        homepageMapper.deleteById(id);
        return new BaseVO();
    }

}
