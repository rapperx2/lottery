package com.qihang.controller.Homepage.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class homepageVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "图标")
    private String pic;
    @ApiModelProperty(value = "店铺id")
    private Integer tid;
    @ApiModelProperty(value = "描述")
    private String describea;
}
