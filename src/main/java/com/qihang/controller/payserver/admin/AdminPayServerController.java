package com.qihang.controller.payserver.admin;

import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.payserver.admin.dto.AdminPayServerDTO;
import com.qihang.controller.payserver.admin.vo.AdminPayServerVo;
import com.qihang.service.payserver.IPayserverService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/admin/payserver")
public class AdminPayServerController {
    @Resource
    private IPayserverService PayserverService;

    @PostMapping("/list")
    @ApiOperation("列表接口")
    public CommonListVO<AdminPayServerVo> List(@RequestBody @Valid AdminPayServerDTO adminPD) {
        return PayserverService.List(adminPD);
    }
    @PostMapping("/edit")
    @ApiOperation("编辑支付方式")
    public BaseVO edit(@RequestBody @Valid AdminPayServerDTO adminPayServer) {
        System.out.println("==================================a=aaaaaaaaaaaaaaaaaaaaaaa"+adminPayServer);
        return PayserverService.edit(adminPayServer);
    }
    @PostMapping("/add")
    @ApiOperation("添加支付方式")
    public BaseVO add(@RequestBody @Valid AdminPayServerDTO adminPayServer) {
        return PayserverService.add(adminPayServer);
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    public BaseVO delete(@PathVariable("id") Integer id) {
        return PayserverService.delete(id);
    }

}