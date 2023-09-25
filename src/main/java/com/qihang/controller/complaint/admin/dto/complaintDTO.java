package com.qihang.controller.complaint.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class complaintDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "手机号", required = true)
    private String phone;
    @ApiModelProperty(value = "问题描述", required = true)
    private String descriptor;
    @ApiModelProperty(value = "问题类型")
    private String type;
    @ApiModelProperty(value = "图片")
    private String pic;
    @ApiModelProperty(value = "用户ID")
    private Integer userid;
    @ApiModelProperty(value = "回复")
    private String reply;


}
