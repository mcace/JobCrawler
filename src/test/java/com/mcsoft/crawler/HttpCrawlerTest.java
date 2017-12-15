package com.mcsoft.crawler;

import com.mcsoft.bean.lagou.LagouFormParam;
import com.mcsoft.bean.lagou.LagouURLParam;
import com.mcsoft.utils.ConfigLoader;
import com.mcsoft.utils.Constants;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Mc on 2017/12/8.
 */
public class HttpCrawlerTest {
    @Test
    public void craw() throws Exception {
//        String url = "https://www.baidu.com";
//        HttpCrawler httpCrawler = new HttpCrawler("GET", null, null);
        String url = Constants.getLagouAjaxUrl(LagouURLParam.defaultURLParams());
        String body = LagouFormParam.defaultFormParams();
        Map<String, String> headers = ConfigLoader.loadConfig("headers.properties");
        HttpCrawler httpCrawler = new HttpCrawler("POST", body, headers);
        String page = httpCrawler.craw(url);
        System.out.println(page);
    }

}