package com.qihang.controller.Homepage.admin;

import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.Homepage.admin.dto.homepageDTO;
import com.qihang.controller.Homepage.admin.vo.homepageVO;
import com.qihang.service.homepage.IHomepageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/admin/homepage")
public class HomepageController {
    @Resource
    private IHomepageService homepageService;
    @PostMapping("/list")
    @ApiOperation("店铺列表接口")
    public CommonListVO<homepageVO> HomeadminList(@RequestBody @Valid homepageDTO homepage) {
        return homepageService.List(homepage);
    }
    @PostMapping("/add")
    @ApiOperation("添加接口")
    public BaseVO add(@RequestBody @Valid homepageDTO homepage) {
        return homepageService.add(homepage);
    }
    @PostMapping("/update")
    @ApiOperation("编辑接口")
    public BaseVO update(@RequestBody @Valid homepageDTO homepage) {
        return homepageService.update(homepage);
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    public BaseVO delete(@PathVariable("id") Integer id) {
        return homepageService.delete(id);
    }
}
