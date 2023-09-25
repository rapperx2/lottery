package com.qihang.controller.order.admin.lottery.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class LotteryOrderadminDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "图片")
    private String pic;
}
