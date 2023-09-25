package com.qihang.footballreptile;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qihang.constant.CrawlingAddressConstant;
import com.qihang.domain.footballlottery.FootballlotteryMatchDO;
import com.qihang.domain.halftheaudience.HalftheaudienceMatchDO;
import com.qihang.service.footballlottery.IFootballlotteryMatchService;
import com.qihang.service.halftheaudiencematch.IHalftheaudienceMatchService;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Component
public class FootballlotteryPipeline implements Pipeline {
    @Resource
    private IFootballlotteryMatchService footballMatchService;
    @Resource
    private IHalftheaudienceMatchService halftheaudienceMatchService;
    @Override
    public void process(ResultItems resultItems, Task task) {
        String url = resultItems.getRequest().getUrl();
        if (ObjectUtil.equal(url, CrawlingAddressConstant.URL25)) {
            List<FootballlotteryMatchDO> footballMatchList = resultItems.get("footballlotteryGoalList");
            for (FootballlotteryMatchDO footballMatchDO : footballMatchList) {
                FootballlotteryMatchDO footballMatch = footballMatchService.getOne(new QueryWrapper<FootballlotteryMatchDO>().lambda()
                        .eq(FootballlotteryMatchDO::getMatch, footballMatchDO.getMatch())
                        .eq(FootballlotteryMatchDO::getNumber, footballMatchDO.getNumber())
                );


                if (ObjectUtil.isNotNull(footballMatch)) {
                    footballMatchDO.setId(footballMatch.getId());
                    footballMatchDO.setUpdateTime(new Date());
                }

            }

            footballMatchService.saveOrUpdateBatch(footballMatchList);
        }else if(ObjectUtil.equal(url, CrawlingAddressConstant.URL26)){
            List<HalftheaudienceMatchDO> halftheaudiencematchlist = resultItems.get("halftheaudiencematchDOGoalList");
            for (HalftheaudienceMatchDO footballMatchDO : halftheaudiencematchlist) {
                HalftheaudienceMatchDO halftheaudienceMatch = halftheaudienceMatchService.getOne(new QueryWrapper<HalftheaudienceMatchDO>().lambda()
                        .eq(HalftheaudienceMatchDO::getMatch, footballMatchDO.getMatch())
                        .eq(HalftheaudienceMatchDO::getNumber, footballMatchDO.getNumber())
                );


                if (ObjectUtil.isNotNull(halftheaudienceMatch)) {
                    halftheaudienceMatch.setId(halftheaudienceMatch.getId());
                    halftheaudienceMatch.setUpdateTime(new Date());
                }

            }
            System.out.println("2============================================="+halftheaudiencematchlist);
            halftheaudienceMatchService.saveOrUpdateBatch(halftheaudiencematchlist);

        }
    }
}
