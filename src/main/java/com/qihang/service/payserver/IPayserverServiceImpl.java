package com.qihang.service.payserver;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.payserver.admin.dto.AdminPayServerDTO;
import com.qihang.controller.payserver.admin.vo.AdminPayServerVo;
import com.qihang.domain.payserver.payserverDO;
import com.qihang.mapper.payserver.PayserverMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IPayserverServiceImpl extends ServiceImpl<PayserverMapper, payserverDO> implements IPayserverService {
    @Resource
    private PayserverMapper PayserverMapper;
    @Override
    public CommonListVO<AdminPayServerVo> List(AdminPayServerDTO adminPD) {
        CommonListVO<AdminPayServerVo> commonList = new CommonListVO<>();
        List<payserverDO> textList = PayserverMapper.selectList(new QueryWrapper<payserverDO>().lambda().eq(payserverDO::getTid,adminPD.getTid()));
        List<AdminPayServerVo> list = BeanUtil.copyToList(textList, AdminPayServerVo.class);
        commonList.setVoList(list);
        return commonList;
    }

    @Override
    public BaseVO edit(AdminPayServerDTO payRecharge) {
        payserverDO pay = PayserverMapper.selectById(payRecharge.getId());
        pay.setSefKey(payRecharge.getSefKey());
        pay.setPubKey(payRecharge.getPubKey());
        pay.setAlipayRootCert(payRecharge.getAlipayRootCert());
        pay.setAppCertPublicKey(payRecharge.getAppCertPublicKey());
        pay.setMerchant(payRecharge.getMerchant());
        pay.setTitle(payRecharge.getTitle());
        PayserverMapper.updateById(pay);
        return new BaseVO();
    }

    @Override
    public BaseVO add(AdminPayServerDTO shopRecharge) {
        payserverDO shop = new payserverDO();
        shop.setMerchant(shopRecharge.getMerchant());
        shop.setAlipayRootCert(shopRecharge.getAlipayRootCert());
        shop.setAppCertPublicKey(shopRecharge.getAppCertPublicKey());
        shop.setPubKey(shopRecharge.getPubKey());
        shop.setTitle(shopRecharge.getTitle());
        shop.setType(shopRecharge.getType());
        shop.setSefKey(shopRecharge.getSefKey());
        shop.setTid(shopRecharge.getTid());
        PayserverMapper.insert(shop);
        return new BaseVO();
    }
    @Override
    public BaseVO delete(Integer id) {
        PayserverMapper.deleteById(id);
        return new BaseVO();
    }




}
