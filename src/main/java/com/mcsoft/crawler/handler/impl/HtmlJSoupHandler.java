package com.mcsoft.crawler.handler.impl;

import com.mcsoft.crawler.handler.AbstractRuleMapHandler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, String> resultMap = new HashMap<>();
        if (null == ruleMap || ruleMap.size() == 0 || null == content || "".equals(content)) {
            return null;
        }
        Document document = Jsoup.parse(content);
        for (Map.Entry<String, String> entry : ruleMap.entrySet()) {
            String name = entry.getKey();
            String value = "";
            String[] rules = entry.getValue().split("\\|");
            if (0 == rules.length) {
                continue;
            }
            Elements nodes = document.select(rules[0]);
            int finalIndex = rules.length - 1;
            for (int i = 1; i < finalIndex; i++) {
                String rule = rules[i];
                nodes = nodes.select(rule);
            }
            if(nodes.isEmpty()){
                System.out.println("规则设置有问题，爬取的页面没有获取到node:"+name);
                return null;
            }
            if ("text".equals(rules[finalIndex])) {
                value = nodes.text();
            } else if (rules[finalIndex].startsWith("[")) {
                value = nodes.first().attr(rules[finalIndex]
                        .substring(1, rules[finalIndex].length() - 1));
            }
            resultMap.put(name, value);
        }
        return resultMap;
    }
}
