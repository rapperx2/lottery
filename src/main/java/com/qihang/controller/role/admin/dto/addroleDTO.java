package com.qihang.controller.role.admin.dto;

import com.qihang.controller.role.admin.vo.permissionsVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class addroleDTO implements Serializable {
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
    @ApiModelProperty(value = "选中")
    private String roleTitle;
    @ApiModelProperty(value = "权限列表")
    List<permissionsVO> permissionsList;
}
