package com.qihang.controller.text.admin;

import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.text.admin.dto.AdminTextDTO;
import com.qihang.controller.text.admin.vo.AdninTextVO;
import com.qihang.service.text.ITextService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/admin/text")
public class AdminTextController {
    @Resource
    private ITextService textService;

    @PostMapping("/list")
    @ApiOperation("列表接口")
    public CommonListVO<AdninTextVO> List(@RequestBody @Valid AdminTextDTO dminText) {
        return textService.List(dminText);
    }

    @PostMapping("/add")
    @ApiOperation("添加店铺接口")
    public BaseVO add(@RequestBody @Valid AdminTextDTO addShop) {
        return textService.add(addShop);
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除店铺")
    public BaseVO delete(@PathVariable("id") Integer id) {
        return textService.delete(id);
    }
    @PostMapping("/edit")
    @ApiOperation("店铺编辑接口")
    public BaseVO edit(@RequestBody @Valid AdminTextDTO addShop) {
        return textService.edit(addShop);
    }
}
