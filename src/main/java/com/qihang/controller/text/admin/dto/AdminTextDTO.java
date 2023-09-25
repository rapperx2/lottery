package com.qihang.controller.text.admin.dto;

import com.qihang.common.dto.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AdminTextDTO extends PageDTO {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String title;

    @ApiModelProperty(value = "图片")
    private String pic;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "内容")
    private Integer tid;
}
