package com.qihang.service.text;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.text.admin.dto.AdminTextDTO;
import com.qihang.controller.text.admin.vo.AdninTextVO;
import com.qihang.domain.text.TextDO;

public interface ITextService extends IService<TextDO> {
    /**
     * 后台列表
     *
     * @param
     * @return
     */

    CommonListVO<AdninTextVO> List(AdminTextDTO dminText);

    BaseVO add(AdminTextDTO shopRecharge);

    BaseVO edit(AdminTextDTO shopRecharge);

    BaseVO delete(Integer id);
}
