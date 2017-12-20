package com.mcsoft.crawler.handler;

import java.util.Map;

/**
 * 抽象附带规则型的数据处理器
 * Created by Mc on 2017/12/20.
 */
public abstract class AbstractRuleMapHandler<T> implements CrawHandler<T> {
    private Map<String, String> ruleMap;

    public AbstractRuleMapHandler(Map<String, String> ruleMap) {
        this.ruleMap = ruleMap;
    }

    public Map<String, String> getRuleMap() {
        return ruleMap;
    }

    public void setRuleMap(Map<String, String> ruleMap) {
        this.ruleMap = ruleMap;
    }

    public String getRule(String ruleName) {
        return ruleMap.get(ruleName);
    }

    public void setRule(String ruleName, String rule) {
        ruleMap.put(ruleName, rule);
    }
}
