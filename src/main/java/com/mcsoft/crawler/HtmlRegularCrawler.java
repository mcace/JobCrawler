package com.mcsoft.crawler;

import com.mcsoft.utils.PageLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 页面正则匹配爬虫
 * 将页面按照对应的正则规则获取出键值对，键为规则名，值为对应正则匹配出的数据
 * Created by Mc on 2017/12/8.
 */
public class HtmlRegularCrawler extends AbstractCrawler<Map<String, String>> {
    private Map<String, String> ruleMap;

    public HtmlRegularCrawler(String method, String body, Map<String, String> headers, Map<String,
            String> ruleMap) {
        super(method, body, headers);
        this.ruleMap = ruleMap;
    }

    public Map<String, String> craw(String url) {
        Map<String, String> result = new HashMap<String, String>();
        if (ruleMap.size() == 0 || null == url || url.equals("")) {
            return result;
        }
        String page = PageLoader.loadPage(url, "GET", headers, "");
        if (page == null || page.equals("")) {
            return result;
        }
        for (Map.Entry<String, String> entry : ruleMap.entrySet()) {
            String name = entry.getKey();
            Pattern pattern = Pattern.compile(entry.getValue());
            Matcher matcher = pattern.matcher(page);
            while (matcher.find()) {
                result.put(name, matcher.group());
            }
        }
        return result;
    }
}