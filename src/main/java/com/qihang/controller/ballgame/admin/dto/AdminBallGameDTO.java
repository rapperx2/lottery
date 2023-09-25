package com.qihang.controller.ballgame.admin.dto;

import com.qihang.common.dto.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: qihang
 * @description:
 * @time: 2022-11-13 11:31
 */
@Data
public class AdminBallGameDTO extends PageDTO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "名字")
    private String name;

}
