package com.qihang.controller.rackingrecords.admin;

import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.rackingrecords.admin.dto.pagerackingrecordsDTO;
import com.qihang.controller.rackingrecords.admin.dto.rackingrecordsDTO;
import com.qihang.controller.rackingrecords.admin.vo.rackingrecordsVO;
import com.qihang.service.rackingrecords.IRackingRecordsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/admin/rackingrecords")
public class AdminrackingRecordsController {
    @Resource
    private IRackingRecordsService IrackingrecordsService;
    @PostMapping("/edit")
    @ApiOperation("编辑接口")
    public BaseVO edit(@RequestBody @Valid rackingrecordsDTO addShop) {
        return IrackingrecordsService.update(addShop);
    }
    @PostMapping("/add")
    @ApiOperation("添加接口")
    public BaseVO add(@RequestBody @Valid rackingrecordsDTO addShop) {
        return IrackingrecordsService.add(addShop);
    }
    @PostMapping("/list")
    @ApiOperation("列表接口")
    public CommonListVO<rackingrecordsVO> List(@RequestBody @Valid pagerackingrecordsDTO shop) {
        return IrackingrecordsService.List(shop);
    }
}
