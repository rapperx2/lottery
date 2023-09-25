package com.qihang.controller.ballgame.admin;

import com.qihang.common.vo.BaseVO;
import com.qihang.controller.ballgame.admin.dto.AdminBallGameDTO;
import com.qihang.service.ballgame.IBallGameService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.validation.Valid;


/**
 * @author: qihang
 * @description:
 * @time: 2022-10-03 21:04
 */
@RestController
@RequestMapping("/admin/ball")
public class AdminBallGameController {

    @Resource
    private IBallGameService ballGameService;
    @Resource
    private ServletRequest request;

    @PostMapping("/list")
    @ApiOperation("福彩接口")
    public BaseVO list() {
        return ballGameService.adminList();
    }

    //@RequestMapping(value = "/adminlistall",method = RequestMethod.POST)
    @PostMapping("/adminlistall")
    @ApiOperation("福彩接口")
    public BaseVO adminlistall(@RequestBody @Valid AdminBallGameDTO adminBallGame) {
        return ballGameService.adminListall(adminBallGame);
    }

    @PutMapping("/update/line/{id}/{type}")
    @ApiOperation("福彩上下架接口")
    public BaseVO updateLine(@PathVariable("id") Integer id, @PathVariable("type") String type) {
        return ballGameService.updateLine(id, type);
    }
}
