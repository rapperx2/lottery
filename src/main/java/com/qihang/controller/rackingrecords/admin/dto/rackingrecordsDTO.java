package com.qihang.controller.rackingrecords.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class rackingrecordsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    private Integer id;
    /**
     * 发起跟单佣金比例配置1
     */
    @ApiModelProperty(value = "发起跟单佣金比例配置1")
    private BigDecimal commission1;
    /**
     * 发起跟单佣金比例配置2
     */
    @ApiModelProperty(value = "发起跟单佣金比例配置2")
    private BigDecimal commission2;
    /**
     * 发起跟单佣金比例配置3
     */
    @ApiModelProperty(value = "发起跟单佣金比例配置3")
    private BigDecimal commission3;
    /**
     * 发起跟单佣金比例配置4
     */
    @ApiModelProperty(value = "发起跟单佣金比例配置4")
    private BigDecimal commission4;
    /**
     * 发起跟单最低金额
     */
    @ApiModelProperty(value = "发起跟单最低金额")
    private BigDecimal MinAmount;
    /**
     * 发起跟单功能开关
     */
    @ApiModelProperty(value = "发起跟单功能开关")
    private Integer state;
    @ApiModelProperty(value = "店铺ID")
    private Integer tenantId;
}
