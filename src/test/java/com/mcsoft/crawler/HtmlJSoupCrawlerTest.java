package com.mcsoft.crawler;

import com.mcsoft.utils.ConfigLoader;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Mc on 2017/12/21.
 */
public class HtmlJSoupCrawlerTest {

    @Test
    public void handle() {
        Map<String, String> headers = ConfigLoader.loadLagouHtmlHeaders();
        Map<String, String> ruleMap = ConfigLoader.loadLagouPositionDetailRules();
        String url = "https://www.lagou.com/jobs/39136.html";

        HtmlJSoupCrawler crawler = new HtmlJSoupCrawler(headers,ruleMap);
        Map<String,String> result = crawler.craw(url);

        for (Map.Entry entry : result.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

}