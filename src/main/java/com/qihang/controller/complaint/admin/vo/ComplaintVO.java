package com.qihang.controller.complaint.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ComplaintVO {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "联系方式")
    private String phone;
    @ApiModelProperty(value = "类型")
    private String type;
    @ApiModelProperty(value = "问题描述")
    private String descriptor;
    @ApiModelProperty(value = "图片")
    private String pic;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "回复")
    private String reply;
    @ApiModelProperty(value = "店铺ID")
    private String tid;
    @ApiModelProperty(value = "用户ID")
    private Integer userid;


}
