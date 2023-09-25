package com.qihang.controller.user.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class UserAgentEditDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private String id;


    @ApiModelProperty(value = "是否代理")
    private String IsAgent;
}
