package com.qihang.controller.rackingrecords.admin.dto;

import com.qihang.common.dto.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class pagerackingrecordsDTO extends PageDTO {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    private Integer id;
}
