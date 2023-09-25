package com.qihang.controller.ballgame.app.dto;

import com.qihang.common.dto.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BallGameDTO extends PageDTO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "tid")
    private Integer tid;
}
