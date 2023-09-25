package com.qihang.controller.permissions.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class PermissionsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "组")
    private String roleGroups;

    @ApiModelProperty(value = "名称")
    private String rolePermissionName;

    @ApiModelProperty(value = "路径")
    private String rolePaths;

    @ApiModelProperty(value = "选中状态")
    private Integer roleCheckeds;

    @ApiModelProperty(value = "标题")
    private String roleTitle;

    @ApiModelProperty(value = "id")
    private Integer roleId;
}
