package com.qihang.service.shop;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qihang.annotation.TenantIgnore;
import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.shop.admin.dto.AddShopDTO;
import com.qihang.controller.shop.admin.dto.AdminShopDTO;
import com.qihang.controller.shop.admin.dto.EditShopDTO;
import com.qihang.controller.shop.admin.dto.ShopRechargeDTO;
import com.qihang.controller.shop.admin.vo.AdminShopVO;
import com.qihang.controller.shop.app.dto.ShopDTO;
import com.qihang.controller.shop.app.vo.ShopVO;
import com.qihang.domain.shop.ShopDO;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author qihang
 * @since 2022-11-13
 */
public interface IShopService extends IService<ShopDO> {

    /**
     * 根据手机号查询店铺列表
     *
     * @param shop
     * @return
     */
    CommonListVO<AdminShopVO> shopadminList(AdminShopDTO adminShop);
    /**
     * 根据手机号查询店铺列表
     *
     * @param shop
     * @return
     */
    CommonListVO<ShopVO> shopList(ShopDTO shop);

    /**
     * 后台列表
     *
     * @param adminShop
     * @return
     */
    CommonListVO<AdminShopVO> adminShopList(AdminShopDTO adminShop);


    /**
     * 上下架
     *
     * @param id
     * @param type
     * @return
     */
    BaseVO updateLine(Integer id, String type);


    /**
     * 添加店铺
     *
     * @param addShop
     * @param userId
     * @return
     */
    BaseVO add(AddShopDTO addShop, Integer userId);
    /**
     * 编辑
     *
     * @param addShop
     * @param userId
     * @return
     */
    @TenantIgnore
    @Transactional(rollbackFor = Exception.class)
    BaseVO shopedit(EditShopDTO addShop, Integer userId);

    /**
     * 添加店铺
     *
     * @param addShop
     * @param userId
     * @return
     */
    BaseVO shopadd(AddShopDTO addShop, Integer userId);

    /**
     * 店铺充值
     *
     * @param shopRecharge
     * @return
     */
    BaseVO recharge(ShopRechargeDTO shopRecharge);

    /**
     * 根据id查询店铺信息
     *
     * @param id
     * @return
     */
    ShopDO getShopById(Integer id);

    /**
     * 删除店铺
     *
     * @param id
     * @return
     */
    BaseVO delete(Integer id);

    CommonListVO<AdminShopVO> shopadminnopageList();
}
