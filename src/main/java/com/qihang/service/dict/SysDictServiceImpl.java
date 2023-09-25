package com.qihang.service.dict;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qihang.annotation.TenantIgnore;
import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.constant.Constant;
import com.qihang.controller.dict.dto.SysDictDTO;
import com.qihang.controller.dict.vo.SysDictQueryVO;
import com.qihang.domain.dict.SysDictDO;
import com.qihang.mapper.dict.SysDictMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author qihang
 * @since 2022-11-14
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDictDO> implements ISysDictService {

    @Resource
    private SysDictMapper sysDictMapper;

    @Override
    @TenantIgnore
    @Transactional(rollbackFor = Exception.class)
    public BaseVO insert(SysDictDTO sysDict) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        int tid = Integer.parseInt(servletRequestAttributes.getRequest().getHeader("X-Tenant-Id"));
        if (sysDict.getType() == 2) {
//            sysDictMapper.delete(new QueryWrapper<SysDictDO>().lambda().eq(SysDictDO::getTenantId, sysDict.getTenantId()));

            SysDictDO sysDictDO = new SysDictDO();
            sysDictDO.setCode(Constant.ALIPAY_APPID_KAY);
            sysDictDO.setValue(sysDict.getAliPayAppId());
            sysDictDO.setTenantId(tid);
            sysDictDO.setDictDesc("支付宝appid");
            sysDictDO.setCreateTime(new Date());
            sysDictDO.setUpdateTime(new Date());
            sysDictMapper.insert(sysDictDO);

            sysDictDO = new SysDictDO();
            sysDictDO.setCode(Constant.ALIPAY_PUBLIC_KAY);
            sysDictDO.setValue(sysDict.getAlipayPublicKey());
            sysDictDO.setTenantId(tid);
            sysDictDO.setDictDesc("支付宝公钥");
            sysDictDO.setCreateTime(new Date());
            sysDictDO.setUpdateTime(new Date());
            sysDictMapper.insert(sysDictDO);

            sysDictDO = new SysDictDO();
            sysDictDO.setCode(Constant.ALIPAY_PRIVATE_KAY);
            sysDictDO.setValue(sysDict.getAlipayPrivateKey());
            sysDictDO.setTenantId(tid);
            sysDictDO.setDictDesc("支付宝私钥");
            sysDictDO.setCreateTime(new Date());
            sysDictDO.setUpdateTime(new Date());
            sysDictMapper.insert(sysDictDO);
            return new BaseVO();
        }else if (sysDict.getType() == 1) {
            //银行卡
            SysDictDO sysDictDO = new SysDictDO();
            //持卡人名称
            sysDictDO.setCode(sysDict.getAlipayPublicKey());
            //卡号
            sysDictDO.setValue(sysDict.getAliPayAppId());
            sysDictDO.setTenantId(tid);
            //银行名称
            sysDictDO.setDictDesc(sysDict.getAlipayPrivateKey());
            sysDictDO.setCreateTime(new Date());
            sysDictDO.setUpdateTime(new Date());
            sysDictMapper.insert(sysDictDO);
            return new BaseVO();
        }else if(sysDict.getType() == 3){
            //二维码
            SysDictDO sysDictDO = new SysDictDO();
            //图片地址
            sysDictDO.setValue(sysDict.getAliPayAppId());
            sysDictDO.setTenantId(tid);
            sysDictDO.setDictDesc("二维码");
            sysDictDO.setCreateTime(new Date());
            sysDictDO.setUpdateTime(new Date());
            sysDictMapper.insert(sysDictDO);
            return new BaseVO();
        }
        return  new BaseVO();
    }

    @Override
    @TenantIgnore
    public CommonListVO<SysDictQueryVO> queryDictByTenantId(Integer tenantId) {
        CommonListVO<SysDictQueryVO> commonList = new CommonListVO<>();
        List<SysDictDO> dictList = sysDictMapper.selectList(new QueryWrapper<SysDictDO>().lambda().eq(SysDictDO::getTenantId, tenantId));
        List<SysDictQueryVO> list = BeanUtil.copyToList(dictList, SysDictQueryVO.class);
        commonList.setVoList(list);
        return commonList;
    }

    @Override
    public BaseVO delete(Integer id) {
        sysDictMapper.deleteById(id);
        return new BaseVO();
    }

    @Override
    public CommonListVO<SysDictQueryVO> queryListByTenantId() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        int tid = Integer.parseInt(servletRequestAttributes.getRequest().getHeader("X-Tenant-Id"));

        CommonListVO<SysDictQueryVO> commonList = new CommonListVO<>();
        List<SysDictDO> dictList = sysDictMapper.selectList(new QueryWrapper<SysDictDO>().lambda().eq(SysDictDO::getTenantId, tid));
        List<SysDictQueryVO> list = BeanUtil.copyToList(dictList, SysDictQueryVO.class);
        commonList.setVoList(list);
        return commonList;
    }
}
