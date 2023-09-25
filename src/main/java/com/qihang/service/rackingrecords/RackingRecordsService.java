package com.qihang.service.rackingrecords;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.rackingrecords.admin.dto.pagerackingrecordsDTO;
import com.qihang.controller.rackingrecords.admin.dto.rackingrecordsDTO;
import com.qihang.controller.rackingrecords.admin.vo.rackingrecordsVO;
import com.qihang.domain.TrackingRecords.rackingRecordsDO;
import com.qihang.mapper.rackingrecords.rackingRecordsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RackingRecordsService extends ServiceImpl<rackingRecordsMapper, rackingRecordsDO> implements IRackingRecordsService {
    @Resource
    private rackingRecordsMapper rackingrecordsMapper;
    @Override
    public BaseVO update(rackingrecordsDTO rackingrecords) {
        rackingRecordsDO racking = rackingrecordsMapper.selectById(rackingrecords.getId());
        racking.setState(rackingrecords.getState());
        racking.setCommission1(rackingrecords.getCommission1());
        racking.setCommission2(rackingrecords.getCommission2());
        racking.setCommission3(rackingrecords.getCommission3());
        racking.setCommission4(rackingrecords.getCommission4());
        racking.setMinAmount(rackingrecords.getMinAmount());

        rackingrecordsMapper.updateById(racking);

        return new BaseVO();
    }
    @Override
    public BaseVO add(rackingrecordsDTO rackingrecords) {
        rackingRecordsDO racking = new rackingRecordsDO();
        racking.setState(rackingrecords.getState());
        racking.setCommission1(rackingrecords.getCommission1());
        racking.setCommission2(rackingrecords.getCommission2());
        racking.setCommission3(rackingrecords.getCommission3());
        racking.setCommission4(rackingrecords.getCommission4());
        racking.setMinAmount(rackingrecords.getMinAmount());
        racking.setTenantId(rackingrecords.getTenantId());
        rackingrecordsMapper.insert(racking);

        return new BaseVO();
    }
    @Override
    public CommonListVO<rackingrecordsVO> List(pagerackingrecordsDTO adminShop) {
        CommonListVO<rackingrecordsVO> commonList = new CommonListVO<>();
        //分页
        Page<rackingRecordsDO> page = new Page<>(adminShop.getPageNo(), adminShop.getPageSize());
        LambdaQueryWrapper<rackingRecordsDO> qw = new QueryWrapper<rackingRecordsDO>().lambda();
        qw.eq(rackingRecordsDO::getTenantId,adminShop.getId());
        qw.orderByDesc(rackingRecordsDO::getId);
        Page<rackingRecordsDO> pageData = rackingrecordsMapper.selectPage(page, qw);
        List<rackingRecordsDO> list = pageData.getRecords();
        List<rackingrecordsVO> shopList = BeanUtil.copyToList(list, rackingrecordsVO.class);
        commonList.setVoList(shopList);
        commonList.setTotal(pageData.getTotal());
        return commonList;
    }
}
