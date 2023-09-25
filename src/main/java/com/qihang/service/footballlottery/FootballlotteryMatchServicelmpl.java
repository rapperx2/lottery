package com.qihang.service.footballlottery;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qihang.domain.footballlottery.FootballlotteryMatchDO;
import com.qihang.mapper.footballlotterymatch.FootballlotteryMatchMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
@Slf4j
public class FootballlotteryMatchServicelmpl extends ServiceImpl<FootballlotteryMatchMapper, FootballlotteryMatchDO> implements IFootballlotteryMatchService {
    @Resource
    private FootballlotteryMatchMapper footballlotteryMatchMapper;

}
