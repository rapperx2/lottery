package com.qihang.controller.notice.app;


import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.notice.app.dto.NoticeDTO;
import com.qihang.controller.notice.app.vo.NoticeVO;
import com.qihang.service.notice.INoticeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 *
 * @author qihang
 * @since 2022-10-08
 */
@RestController
@RequestMapping("/app/notice")
public class AppNoticeController {
    @Resource
    private INoticeService noticeService;

    @PostMapping("/list")
    @ApiOperation("公告列表")
    public CommonListVO<NoticeVO> list(@RequestBody @Valid NoticeDTO notice) {
        return noticeService.List(notice);
    }
}
