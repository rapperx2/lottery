package com.qihang.service.role;

import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.role.admin.dto.addroleDTO;
import com.qihang.controller.role.admin.dto.roleDTO;
import com.qihang.controller.role.admin.vo.roleVO;

public interface IRoleService {
    CommonListVO<roleVO> List(roleDTO role);

    BaseVO add(addroleDTO role);

    BaseVO edit(addroleDTO role);

    BaseVO delete(Integer id);
}
