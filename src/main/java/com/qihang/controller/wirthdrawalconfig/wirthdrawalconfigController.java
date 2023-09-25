package com.qihang.controller.wirthdrawalconfig;

import com.qihang.common.vo.BaseVO;
import com.qihang.controller.wirthdrawalconfig.dto.wirthdrawalconfigDTO;
import com.qihang.controller.wirthdrawalconfig.vo.wirthdrawalconfigVO;
import com.qihang.service.wirthdrawalconfig.IWirthdrawalconfigService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
@RestController
@RequestMapping("/admin/withdrawalconfig")
public class wirthdrawalconfigController {
    @Resource
    private IWirthdrawalconfigService withdrawalService;

//    列表
    @PostMapping("/edit")
    @ApiOperation("提现配置接口")
    public wirthdrawalconfigVO edit(@RequestBody @Valid wirthdrawalconfigDTO withdrawalQuery) {
        return withdrawalService.edit(withdrawalQuery);
    }

    @PostMapping("/updata")
    @ApiOperation("提现配置接口")
    public BaseVO updata(@RequestBody @Valid wirthdrawalconfigDTO withdrawalQuery) {
        return withdrawalService.updata(withdrawalQuery);
    }
}
