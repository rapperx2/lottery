package com.qihang.service.statistics;

import com.qihang.controller.statistics.vo.StatisticsVO;

/**
 * @author: qihang
 * @description:
 * @time: 2022-11-06 13:45
 */
public interface IStatisticsService {

    /**
     * 统计
     *
     * @return
     */

    StatisticsVO calculation(int tid);
}
