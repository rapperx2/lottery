package com.qihang.service.wirthdrawalconfig;

import com.qihang.common.vo.BaseVO;
import com.qihang.controller.wirthdrawalconfig.dto.wirthdrawalconfigDTO;
import com.qihang.controller.wirthdrawalconfig.vo.wirthdrawalconfigVO;

public interface IWirthdrawalconfigService {

    wirthdrawalconfigVO edit(wirthdrawalconfigDTO withdrawalDTO);

    BaseVO updata(wirthdrawalconfigDTO withdrawalDTO);
}
