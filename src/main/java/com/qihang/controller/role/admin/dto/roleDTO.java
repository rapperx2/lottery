package com.qihang.controller.role.admin.dto;

import com.qihang.common.dto.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class roleDTO extends PageDTO {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "权限名称")
    private String name;
    @ApiModelProperty(value = "备注")
    private String describes;
    @ApiModelProperty(value = "是否开启")
    private Integer roleStatus;
    @ApiModelProperty(value = "菜单ID")
    private Integer rolePermissions;
}
