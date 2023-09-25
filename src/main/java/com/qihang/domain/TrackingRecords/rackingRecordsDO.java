package com.qihang.domain.TrackingRecords;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_tracking_records")
public class rackingRecordsDO implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 发起跟单佣金比例配置1
     */
    private BigDecimal commission1;
    /**
     * 发起跟单佣金比例配置2
     */
    private BigDecimal commission2;
    /**
     * 发起跟单佣金比例配置3
     */
    private BigDecimal commission3;
    /**
     * 发起跟单佣金比例配置4
     */
    private BigDecimal commission4;
    /**
     * 发起跟单最低金额
     */
    private BigDecimal MinAmount;
    /**
     * 发起跟单功能开关
     */
    private Integer state;
    private Integer tenantId;

}
