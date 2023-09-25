package com.qihang.service.homepage;

import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.Homepage.admin.dto.homepageDTO;
import com.qihang.controller.Homepage.admin.vo.homepageVO;

public interface IHomepageService {
    CommonListVO<homepageVO> List(homepageDTO adminHome);

    BaseVO add(homepageDTO adminHome);

    BaseVO update(homepageDTO adminHome);

    BaseVO delete(Integer id);
}
