package com.qihang.controller.role.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class permissionsVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "权限名称")
    private String name;
    @ApiModelProperty(value = "组")
    private String roleGroups;
    @ApiModelProperty(value = "菜单名称")
    private String rolePermissionName;
    @ApiModelProperty(value = "URL")
    private String rolePaths;
    @ApiModelProperty(value = "选中")
    private Integer roleCheckeds;
    @ApiModelProperty(value = "选中")
    private String roleTitle;


}
