package com.qihang.domain.payserver;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_pay_server")
public class payserverDO implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    private String title;
    /**
     * type
     */
    private Integer type;
    /**
     * pub_key
     */
    private String pubKey;
    /**
     * sef_key
     */
    private String sefKey;
    /**
     * alipayRootCert
     */
    private String alipayRootCert;
    /**
     * appCertPublicKey
     */
    private String appCertPublicKey;
    /**
     * merchant
     */
    private String merchant;

    private Integer tid;
}
