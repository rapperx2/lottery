package com.qihang.controller.notice.app.dto;

import cn.hutool.core.date.DateTime;
import com.qihang.common.dto.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class NoticeDTO extends PageDTO {
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
