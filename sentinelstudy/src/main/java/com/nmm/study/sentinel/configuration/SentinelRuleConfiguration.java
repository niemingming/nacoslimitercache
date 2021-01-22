package com.nmm.study.sentinel.configuration;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化规则信息
 */
@Component
public class SentinelRuleConfiguration implements InitializingBean {
    public void afterPropertiesSet() throws Exception {
        List<FlowRule> rules = new ArrayList<FlowRule>();
        FlowRule flowRule = new FlowRule("one");
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule.setCount(10);
        rules.add(flowRule);
        FlowRuleManager.loadRules(rules);
    }
}
