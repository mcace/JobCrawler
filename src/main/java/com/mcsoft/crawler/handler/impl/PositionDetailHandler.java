package com.mcsoft.crawler.handler.impl;

import com.mcsoft.bean.lagou.LagouPositionDetail;
import com.mcsoft.crawler.handler.AbstractRuleMapHandler;

import java.util.Map;

/**
 * 职位详情数据处理器
 * Created by Mc on 2017/12/20.
 */
public class PositionDetailHandler extends AbstractRuleMapHandler<LagouPositionDetail> {
    private HtmlJSoupHandler jsoupHandler;

    public PositionDetailHandler(Map<String, String> ruleMap) {
        super(ruleMap);
        this.jsoupHandler = new HtmlJSoupHandler(ruleMap);
    }

    @Override
    public LagouPositionDetail handle(String content) {
        LagouPositionDetail result = new LagouPositionDetail();

        if (null == content || "".equals(content)) {
            return null;
        }
        Map<String, String> values = jsoupHandler.handle(content);
        return result;
    }
}
