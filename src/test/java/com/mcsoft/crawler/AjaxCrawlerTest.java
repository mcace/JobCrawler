package com.mcsoft.crawler;

import com.alibaba.fastjson.JSON;
import com.mcsoft.bean.lagou.params.LagouFormParam;
import com.mcsoft.bean.lagou.LagouPositionList;
import com.mcsoft.bean.lagou.params.LagouURLParam;
import com.mcsoft.utils.ConfigLoader;
import com.mcsoft.utils.Constants;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Mc on 2017/12/8.
 */
public class AjaxCrawlerTest {
    @Test
    public void craw() throws Exception {
        LagouPositionList lagouPositionList;
        String url = Constants.getLagouPositionAjaxUrl(LagouURLParam.defaultURLParams());
        Map<String, String> headers = ConfigLoader.loadLagouAjaxHeaders();
        String body = LagouFormParam.defaultFormParams();
        AjaxCrawler<LagouPositionList> crawler = new AjaxCrawler<>(body, headers, LagouPositionList.class);
        lagouPositionList = crawler.craw(url);
        System.out.println(JSON.toJSON(lagouPositionList));
    }

}