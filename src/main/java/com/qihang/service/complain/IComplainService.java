package com.qihang.service.complain;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.complaint.admin.dto.complaintDTO;
import com.qihang.controller.complaint.admin.dto.complaintreplyDTO;
import com.qihang.controller.complaint.admin.vo.ComplaintVO;
import com.qihang.domain.complaint.ComplaintDO;

public interface IComplainService extends IService<ComplaintDO> {
    /**
     * 福彩列表
     *
     * @return
     */
    CommonListVO<ComplaintVO> List();

    CommonListVO<ComplaintVO> Listhome(complaintDTO complaintdto);

    BaseVO add(complaintDTO complaintAdd);

    BaseVO reply(complaintreplyDTO complaintAdd);

    BaseVO delete(Integer id);
}
