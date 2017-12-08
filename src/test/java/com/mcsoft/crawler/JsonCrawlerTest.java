package com.mcsoft.crawler;

import com.alibaba.fastjson.JSON;
import com.mcsoft.bean.lagou.LagouFormParam;
import com.mcsoft.bean.lagou.LagouJson;
import com.mcsoft.bean.lagou.LagouURLParam;
import com.mcsoft.utils.ConfigLoader;
import com.mcsoft.utils.Constants;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Mc on 2017/12/8.
 */
public class JsonCrawlerTest {
    @Test
    public void craw() throws Exception {
        LagouJson lagouJson = new LagouJson();
        String url = Constants.getLagouAjaxUrl(LagouURLParam.defaultURLParams());
        Map<String, String> headers = ConfigLoader.loadLagouHeaders();
        String body = LagouFormParam.defaultFormParams();
        JsonCrawler<LagouJson> crawler = new JsonCrawler<>("POST", body, headers, LagouJson.class);
        lagouJson = crawler.craw(url);
        System.out.println(JSON.toJSON(lagouJson));
    }

}