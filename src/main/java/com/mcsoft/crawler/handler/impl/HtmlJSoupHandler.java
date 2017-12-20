package com.mcsoft.crawler.handler.impl;

import com.mcsoft.crawler.handler.AbstractRuleMapHandler;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * HTML源代码Jsoup处理器
 * Created by Mc on 2017/12/20.
 */
public class HtmlJSoupHandler extends AbstractRuleMapHandler<Map<String, String>> {
    public HtmlJSoupHandler(Map<String, String> ruleMap) {
        super(ruleMap);
    }

    @Override
    public Map<String, String> handle(String content) {
        Map<String, String> ruleMap = this.getRuleMap();
        if (null == ruleMap || ruleMap.size() == 0 || null == content || "".equals(content)) {
            return null;
        }
        for (Map.Entry<String, String> entry : ruleMap.entrySet()) {
            String name = entry.getKey();
            Pattern pattern = Pattern.compile(entry.getValue());
            //Matcher matcher = pattern.matcher(page);
            //while (matcher.find()) {
            // result.put(name, matcher.group());
            //}
        }
        return null;
    }
}
