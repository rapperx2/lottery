package com.qihang.controller.notice.admin.dto;

import com.qihang.common.dto.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class NoticeDTO extends PageDTO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;
    @ApiModelProperty(value = "结束时间")
    private Date endTime;
    @ApiModelProperty(value = "内容")
    private String msg;
}
