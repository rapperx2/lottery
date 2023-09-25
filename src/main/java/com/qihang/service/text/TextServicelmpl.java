package com.qihang.service.text;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.text.admin.dto.AdminTextDTO;
import com.qihang.controller.text.admin.vo.AdninTextVO;
import com.qihang.domain.text.TextDO;
import com.qihang.mapper.text.TextMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TextServicelmpl extends ServiceImpl<TextMapper, TextDO> implements ITextService {
    @Resource
    private TextMapper TextMapper;


    @Override
    public CommonListVO<AdninTextVO> List(AdminTextDTO dminText) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        int tid = Integer.parseInt(servletRequestAttributes.getRequest().getHeader("X-Tenant-Id"));

        CommonListVO<AdninTextVO> commonList = new CommonListVO<>();
        if (dminText.getTid() != null && dminText.getTid()>0 ) {
            List<TextDO> textList = TextMapper.selectList(new QueryWrapper<TextDO>().lambda().eq(TextDO::getTid,dminText.getTid()));
            List<AdninTextVO> list = BeanUtil.copyToList(textList, AdninTextVO.class);
            commonList.setVoList(list);
            return commonList;
        }else {
            List<TextDO> textList = TextMapper.selectList(new QueryWrapper<TextDO>().lambda().eq(TextDO::getTid,tid));
            List<AdninTextVO> list = BeanUtil.copyToList(textList, AdninTextVO.class);
            commonList.setVoList(list);
            return commonList;
        }
    }


    @Override
    public BaseVO add(AdminTextDTO shopRecharge) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        int tid = Integer.parseInt(servletRequestAttributes.getRequest().getHeader("X-Tenant-Id"));
        TextDO shop = new TextDO();
        shop.setTitle(shopRecharge.getTitle());
        shop.setContent(shopRecharge.getContent());
        shop.setPic(shopRecharge.getPic());
        if (shopRecharge.getTid()!=null && shopRecharge.getTid()>0 ) {
            shop.setTid(shopRecharge.getTid());
        }else{
            shop.setTid(tid);
        }
        TextMapper.insert(shop);
        return new BaseVO();
    }
    @Override
    public BaseVO edit(AdminTextDTO shopRecharge) {
        TextDO shop = TextMapper.selectById(shopRecharge.getId());;
        shop.setTitle(shopRecharge.getTitle());
        shop.setContent(shopRecharge.getContent());
        shop.setPic(shopRecharge.getPic());
        shop.setTid(shopRecharge.getTid());
        TextMapper.updateById(shop);
        return new BaseVO();
    }

    @Override
    public BaseVO delete(Integer id) {
        TextMapper.deleteById(id);
        return new BaseVO();
    }


}
