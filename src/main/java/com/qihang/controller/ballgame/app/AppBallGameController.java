package com.qihang.controller.ballgame.app;

import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.ballgame.app.dto.BallGameDTO;
import com.qihang.controller.ballgame.app.vo.BallGameVO;
import com.qihang.service.ballgame.IBallGameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;


/**
 * @author: qihang
 * @description:
 * @time: 2022-10-03 21:04
 */
@RestController
@Api(tags = "app 彩票接口集合")
@RequestMapping("/app/ball")
public class AppBallGameController {

    @Resource
    private IBallGameService ballGameService;

    @PostMapping("/list")
    @ApiOperation("福彩列表")
    public CommonListVO<BallGameVO> list(@RequestBody @Valid BallGameDTO ballGame) {
        return ballGameService.list(ballGame);
    }

}
