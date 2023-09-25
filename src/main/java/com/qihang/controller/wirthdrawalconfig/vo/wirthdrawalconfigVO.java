package com.qihang.controller.wirthdrawalconfig.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class wirthdrawalconfigVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 0 支付宝 1 银行卡
     */
    private String type;

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

    private String withdrawalSwitch;
}
