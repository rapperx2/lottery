package com.qihang.service.notice;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.notice.admin.dto.NoticeDTO;
import com.qihang.controller.notice.admin.vo.NoticeQueryVO;
import com.qihang.controller.notice.app.vo.NoticeVO;
import com.qihang.domain.notice.NoticeDO;

import javax.validation.Valid;

/**
 *
 * @author qihang
 * @since 2022-10-08
 */
public interface INoticeService extends IService<NoticeDO> {

    CommonListVO<NoticeQueryVO> adminList(NoticeDTO noticeShop);

    BaseVO add(NoticeDTO notice);

    CommonListVO<NoticeVO> List(com.qihang.controller.notice.app.dto.@Valid NoticeDTO notice);
}
