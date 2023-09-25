package com.qihang.controller.payserver.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AdminPayServerDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "名称")
    private String title;

    @ApiModelProperty(value = "type")
    private Integer type;

    @ApiModelProperty(value = "公钥证书")
    private String pubKey;

    @ApiModelProperty(value = "私钥")
    private String sefKey;

    @ApiModelProperty(value = "支付宝根证书")
    private String alipayRootCert;

    @ApiModelProperty(value = "应用公钥")
    private String appCertPublicKey;

    @ApiModelProperty(value = "商户号")
    private String merchant;

    @ApiModelProperty(value = "店铺id")
    private Integer tid;

    @ApiModelProperty(value = "id")
    private Integer id;


}
