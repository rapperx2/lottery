package com.qihang.controller.notice.app.vo;

import cn.hutool.core.date.DateTime;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qihang
 * @since 2022-10-08
 */
@Data
public class NoticeVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "公告")
    private String msg;

    @ApiModelProperty(value = "时间")
    private DateTime createTime;

    @ApiModelProperty(value = "tid")
    private Integer tenantId;

}
