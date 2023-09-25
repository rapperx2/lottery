package com.qihang.controller.Homepage.admin.dto;

import com.qihang.common.dto.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class homepageDTO extends PageDTO {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "ID")
    private Integer id;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "图片")
    private String pic;
    @ApiModelProperty(value = "店铺ID")
    private Integer tid;
    @ApiModelProperty(value = "描述")
    private String describea;
}
