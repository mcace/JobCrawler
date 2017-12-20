package com.mcsoft.utils;

import com.mcsoft.bean.lagou.params.LagouFormParam;
import com.mcsoft.bean.lagou.params.LagouURLParam;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Mc on 2017/12/7.
 */
public class PageLoaderTest {
    @Test
    public void loadPage() throws Exception {
        Map<String, String> headers = ConfigLoader.loadLagouAjaxHeaders();
        String body = LagouFormParam.defaultFormParams();
        String url = Constants.getLagouAjaxUrl(LagouURLParam.defaultURLParams());
        String result = PageLoader.loadPage(url, "POST",
                headers, body);
        System.out.println(result);
        //System.out.println(body);
        //System.out.println(url);
    }

}