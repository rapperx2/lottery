package com.qihang.controller.user.admin.dto;

import com.qihang.common.dto.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

/**
 * @author: qihang
 * @description:
 * @time: 2022-10-12 15:38
 */
@Data
public class UserQueryDTO extends PageDTO {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "ID")
    private String id;
    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "身份证号")
    private String idCard;

    @ApiModelProperty(value = "代理")
    private String isAgent;


    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "tenant_id")
    private String tenantId;

}
