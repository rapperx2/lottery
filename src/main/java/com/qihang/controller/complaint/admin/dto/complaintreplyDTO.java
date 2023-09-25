package com.qihang.controller.complaint.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class complaintreplyDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "ID")
    private String id;
    @ApiModelProperty(value = "回复")
    private String reply;

    @ApiModelProperty(value = "tid")
    private Integer tid;
}
