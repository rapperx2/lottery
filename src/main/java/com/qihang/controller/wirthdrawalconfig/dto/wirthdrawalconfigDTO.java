package com.qihang.controller.wirthdrawalconfig.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class wirthdrawalconfigDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 0 待审核 1 已打款 2 拒绝
     */
    private String state;

    /**
     * 0 支付宝 1 银行卡
     */
    private String type;

    /**
     * 租户id
     */
    private Integer tenantId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否自动到账
     */
    private Integer isaccount;
    /**
     * 提现次数
     */
    private Integer withdrawalfrequency;
    /**
     * 提现最大金额
     */
    private BigDecimal maxmoney;
    /**
     * 提现最小金额
     */
    private BigDecimal minmoney;

    private Integer shopId;
    private String withdrawalSwitch;
}
