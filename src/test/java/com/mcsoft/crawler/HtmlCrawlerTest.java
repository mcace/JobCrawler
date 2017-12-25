package com.mcsoft.crawler;

import com.mcsoft.utils.ConfigLoader;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Mc on 2017/12/8.
 */
public class HtmlCrawlerTest {
    @Test
    public void craw() throws Exception {
        //String url = "https://www.baidu.com";
        String url = "https://www.lagou.com/jobs/39136.html";
        //HtmlCrawler htmlCrawler = new HtmlCrawler("GET", null, null);

//        String url = Constants.getLagouPositionAjaxUrl(LagouURLParam.defaultURLParams());
//        String body = LagouFormParam.defaultFormParams();
//        Map<String, String> headers = ConfigLoader.loadConfig("lagou-json-lagou-ajax-headers.properties");
        Map<String, String> headers = ConfigLoader.loadLagouHtmlHeaders();
//        HtmlCrawler htmlCrawler = new HtmlCrawler("POST", body, headers);
        HtmlCrawler htmlCrawler = new HtmlCrawler(headers);

        String page = htmlCrawler.craw(url);
        System.out.println(page);
    }

}