package com.qihang.controller.shop.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class EditShopDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "店铺ID")
    private String id;
    @ApiModelProperty(value = "店铺名")
//    @NotBlank(message = "店铺名不能为空")
    private String name;

    @ApiModelProperty(value = "logo")
//    @NotBlank(message = "logo不能为空")
    private String logo;

    @ApiModelProperty(value = "余额")
//    @NotNull(message = "余额不能为空")
    private BigDecimal balance;
    @ApiModelProperty(value = "上下架")
//    @NotNull(message = "上下架不能为空")
    private String line;

    @ApiModelProperty(value = "是否是充值")
    private String reline;
}
