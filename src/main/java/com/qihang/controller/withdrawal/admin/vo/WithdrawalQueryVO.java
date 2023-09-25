package com.qihang.controller.withdrawal.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: qihang
 * @description:
 * @time: 2022-10-08 21:10
 */
@Data
public class WithdrawalQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "用户昵称")
    private String nickname;
    @ApiModelProperty(value = "用户昵称")
    private Integer userId;

    @ApiModelProperty(value = "用户手机号")
    private String phone;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "身份证号")
    private String idCard;

    @ApiModelProperty(value = "提现金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "0 待审核 1 已打款 2 拒绝")
    private String state;

    @ApiModelProperty(value = "0 支付宝 1 银行卡")
    private String type;

    @ApiModelProperty(value = "支付宝账户")
    private String zfbNumber;

    @ApiModelProperty(value = "银行账号")
    private String bankNumber;

    @ApiModelProperty(value = "银行名称")
    private String bankName;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

//    @ApiModelProperty(value = "是否自动到账")
//    private Boolean isaccount;
//
//    @ApiModelProperty(value = "提现次数")
//    private String withdrawalfrequency;
//
//    @ApiModelProperty(value = "提现最大金额")
//    private Decimal maxmoney;
//
//    @ApiModelProperty(value = "提现最小金额")
//    private Decimal minmoney;

}
