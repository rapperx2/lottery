package com.qihang.controller.statistics;

import com.qihang.controller.statistics.vo.StatisticsVO;
import com.qihang.service.statistics.IStatisticsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

/**
 * @author: qihang
 * @description:
 * @time: 2022-11-06 13:47
 */
@RestController
@RequestMapping("/admin/statistics")
public class StatisticsController {

    @Resource
    private IStatisticsService statisticsService;

    @Resource
    private ServletRequest request;

    @PostMapping("/get")
    @ApiOperation("统计接口")
    public StatisticsVO calculation() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return statisticsService.calculation(Integer.parseInt(servletRequestAttributes.getRequest().getHeader("X-Tenant-Id")));
    }
}
