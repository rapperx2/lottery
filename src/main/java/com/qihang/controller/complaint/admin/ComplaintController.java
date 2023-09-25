package com.qihang.controller.complaint.admin;

import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.complaint.admin.dto.complaintDTO;
import com.qihang.controller.complaint.admin.dto.complaintreplyDTO;
import com.qihang.controller.complaint.admin.vo.ComplaintVO;
import com.qihang.service.complain.IComplainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@Api(tags = "admin 留言反馈接口")
@RequestMapping("/admin/complaint")
public class ComplaintController {
    @Resource
    private IComplainService complainService;
    @GetMapping("/list")
    @ApiOperation("列表接口")
    public CommonListVO<ComplaintVO> List() {
        return complainService.List();
    }
    @PostMapping("/listhome")
    @ApiOperation("列表接口")
    public CommonListVO<ComplaintVO> Listhome(@RequestBody @Valid complaintDTO complaintdto) {
        return complainService.Listhome(complaintdto);
    }
    @PostMapping("/add")
    @ApiOperation("添加留言")
    public BaseVO add(@RequestBody @Valid complaintDTO complaintAdd) {
        return complainService.add(complaintAdd);
    }
    @PostMapping("/reply")
    @ApiOperation("回复")
    public BaseVO reply(@RequestBody @Valid complaintreplyDTO complaintAdd) {
        return complainService.reply(complaintAdd);
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除留言")
    public BaseVO delete(@PathVariable("id") Integer id) {
        return complainService.delete(id);
    }
}
