package com.qihang.controller.notice.admin;


import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.notice.admin.dto.NoticeDTO;
import com.qihang.controller.notice.admin.dto.NoticeUpdateDTO;
import com.qihang.controller.notice.admin.vo.NoticeQueryVO;
import com.qihang.domain.notice.NoticeDO;
import com.qihang.service.notice.INoticeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author qihang
 * @since 2022-10-08
 */
@RestController
@RequestMapping("/admin/notice")
public class AdminNoticeController {
    @Resource
    private INoticeService noticeService;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
   // @PostMapping("/list")
    @ApiOperation("公告列表")
    public CommonListVO<NoticeQueryVO> noticeList(@RequestBody @Valid NoticeDTO notice) {

        return noticeService.adminList(notice);
    }

    @PutMapping("/update/{id}")
    @ApiOperation("修改公告")
    public BaseVO noticeUpdate(@PathVariable("id") Integer id, @RequestBody @Valid NoticeUpdateDTO noticeUpdate) {
        NoticeDO notice = new NoticeDO();
        notice.setId(id);
        notice.setMsg(noticeUpdate.getMsg());
        noticeService.updateById(notice);
        return new BaseVO();
    }

    @PostMapping("/add")
    @ApiOperation("添加")
    public BaseVO add(@RequestBody @Valid NoticeDTO notice) {
        return noticeService.add(notice);
    }
}
