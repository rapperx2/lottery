package com.qihang.footballreptile;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.qihang.constant.CrawlingAddressConstant;
import com.qihang.domain.footballlottery.FootballlotteryMatchDO;
import com.qihang.domain.halftheaudience.HalftheaudienceMatchDO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component

public class FootballlotteryProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(300);


    @Value("${webdriver.chrome.driver.path}")
    private String chromeDriverPath;
    @Resource
    private FootballlotteryPipeline footballlotteryPipeline;


    @Override

    public void process(Page page) {
        Html html = page.getHtml();
        if (ObjectUtil.equal(page.getUrl().toString(), CrawlingAddressConstant.URL25)) {
            List<FootballlotteryMatchDO> footballMatchList = new ArrayList<>();

            List<Selectable> nodes = html.css(".qih-list2 li").nodes();

            String start_time=nodes.get(0).css("li","text").get();

//            String deadlineTime = html.css(".zcfilter-l .zcfilter-endtime", "text").toString();
//            deadlineTime = deadlineTime.substring(deadlineTime.indexOf("：") + 1);
//            deadlineTime = DateUtil.year(DateUtil.date()) + "-" + deadlineTime;
            Selectable foottable = html.xpath("//*[@id='vsTable']");
            List<Selectable> tr = foottable.css("tr").nodes();

            for(int i=0;i< tr.size();i++)
            {
                FootballlotteryMatchDO footballlotteryMatchDO=new FootballlotteryMatchDO();
                footballlotteryMatchDO.setNumber(tr.get(i).css(".td-no","text").toString());
                footballlotteryMatchDO.setMatch(tr.get(i).css(".td-evt a","text").toString());
                footballlotteryMatchDO.setOpenTime(tr.get(i).css(".td-endtime","text").toString());
                footballlotteryMatchDO.setHomeTeam(tr.get(i).css(".td-team .team .team-l i","text").toString()+tr.get(i).css(".td-team .team .team-l a","text").toString());
                footballlotteryMatchDO.setVisitingTeam(tr.get(i).css(".td-team .team .team-r i","text").toString()+tr.get(i).css(".td-team .team .team-r a","text").toString());
                footballlotteryMatchDO.setScoreOdds(StrUtil.join(",", tr.get(i).css(".td-betbtn p span", "text").all()));
                String color = tr.get(i).xpath("//*[@class='td-evt']/a/@style").toString();
                footballlotteryMatchDO.setColor(color.substring(color.indexOf("#"), color.length() - 1));
                footballlotteryMatchDO.setStartTime(start_time);
//                footballlotteryMatchDO.setDeadline(DateUtil.parse(deadlineTime));

                footballMatchList.add(footballlotteryMatchDO);
            }

            page.putField("footballlotteryGoalList", footballMatchList);
        }
        else if(ObjectUtil.equal(page.getUrl().toString(), CrawlingAddressConstant.URL26))
        {
            List<HalftheaudienceMatchDO> halftheaudiencematchlist = new ArrayList<>();
            List<Selectable> nodes = html.css(".qih-list2 li").nodes();

            String start_time=nodes.get(0).css("li","text").get();

//            String deadlineTime = html.css(".zcfilter-l .zcfilter-endtime", "text").toString();
//            deadlineTime = deadlineTime.substring(deadlineTime.indexOf("：") + 1);
//            deadlineTime = DateUtil.year(DateUtil.date()) + "-" + deadlineTime;
            Selectable foottable = html.xpath("//*[@id='vsTable']");
            List<Selectable> tr = foottable.css("tr").nodes();

            for(int i=0;i< tr.size();i++)
            {
                HalftheaudienceMatchDO halftheaudiencematchDO=new HalftheaudienceMatchDO();
                halftheaudiencematchDO.setNumber(tr.get(i).css(".td-no","text").toString());
                halftheaudiencematchDO.setMatch(tr.get(i).css(".td-evt a","text").toString());
                halftheaudiencematchDO.setOpenTime(tr.get(i).css(".td-endtime","text").toString());
                halftheaudiencematchDO.setHomeTeam(tr.get(i).css(".td-team .team .team-l i","text").toString()+tr.get(i).css(".td-team .team .team-l a","text").toString());
                halftheaudiencematchDO.setVisitingTeam(tr.get(i).css(".td-team .team .team-r i","text").toString()+tr.get(i).css(".td-team .team .team-r a","text").toString());
                halftheaudiencematchDO.setScoreOdds(StrUtil.join(",", tr.get(i).css(".td-betbtn p span", "text").all()));
                String color = tr.get(i).xpath("//*[@class='td-evt']/a/@style").toString();
                halftheaudiencematchDO.setColor(color.substring(color.indexOf("#"), color.length() - 1));
                halftheaudiencematchDO.setStartTime(start_time);
//                halftheaudiencematchDO.setDeadline(DateUtil.parse(deadlineTime));
                halftheaudiencematchlist.add(halftheaudiencematchDO);
            }
            System.out.println("============================================="+halftheaudiencematchlist);
            page.putField("halftheaudiencematchDOGoalList", halftheaudiencematchlist);
        }
    }
    @Override
    public Site getSite() {
        return site;
    }

    public void run() {
        Spider.create(new FootballlotteryProcessor()).addUrl(CrawlingAddressConstant.URL25
                        , CrawlingAddressConstant.URL26
                       )
                //自定义下载规则，主要是来处理爬取动态的网站,如果只是爬取静态的这个可以用默认的就行
                // http://chromedriver.storage.googleapis.com/index.html 版本一定会要与浏览器对应
                .setDownloader(new SeleniumDownloader(chromeDriverPath)).setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(10000000))).thread(5).addPipeline(footballlotteryPipeline).run();
    }
}
