package com.mcsoft.crawler;

import com.mcsoft.utils.ConfigLoader;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Mc on 2017/12/8.
 */
public class HttpCrawlerTest {
    @Test
    public void craw() throws Exception {
        //String url = "https://www.baidu.com";
        String url = "https://www.lagou.com/jobs/39136.html";
        //HttpCrawler httpCrawler = new HttpCrawler("GET", null, null);

//        String url = Constants.getLagouAjaxUrl(LagouURLParam.defaultURLParams());
//        String body = LagouFormParam.defaultFormParams();
//        Map<String, String> headers = ConfigLoader.loadConfig("lagou-json-lagou-ajax-headers.properties");
        Map<String, String> headers = ConfigLoader.loadLagouHtmlHeaders();
//        HttpCrawler httpCrawler = new HttpCrawler("POST", body, headers);
        HttpCrawler httpCrawler = new HttpCrawler(headers);

        String page = httpCrawler.craw(url);
        System.out.println(page);
    }

}