package com.qihang.service.payserver;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.payserver.admin.dto.AdminPayServerDTO;
import com.qihang.controller.payserver.admin.vo.AdminPayServerVo;
import com.qihang.domain.payserver.payserverDO;

public interface IPayserverService extends IService<payserverDO> {
    /**
     * 后台列表
     *
     * @param adminlist
     * @return
     */

    CommonListVO<AdminPayServerVo> List(AdminPayServerDTO adminPD);

    BaseVO edit(AdminPayServerDTO shopRecharge);

    BaseVO add(AdminPayServerDTO shopRecharge);

    BaseVO delete(Integer id);
}
