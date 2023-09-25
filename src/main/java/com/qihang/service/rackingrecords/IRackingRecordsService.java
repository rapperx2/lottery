package com.qihang.service.rackingrecords;

import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.rackingrecords.admin.dto.pagerackingrecordsDTO;
import com.qihang.controller.rackingrecords.admin.dto.rackingrecordsDTO;
import com.qihang.controller.rackingrecords.admin.vo.rackingrecordsVO;

public interface IRackingRecordsService {
    BaseVO update(rackingrecordsDTO rackingrecords);

    BaseVO add(rackingrecordsDTO rackingrecords);

    CommonListVO<rackingrecordsVO> List(pagerackingrecordsDTO adminShop);
}
