package com.nmm.study.sentinel.local;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 本地测试
 */
public class LocalTest {
    static int line = 0;
    public static void main(String[] args) throws InterruptedException {
        initFlowRules();
        while (true) {
            Entry entry = null;
            line++;
            if (line > 100) {
                break;
            }
            try {
                //定义资源，我们将资源，相当于一下的操作都是资源HelloWorld的操作。
                entry = SphU.entry("HelloWorld");
                //正常执行的逻辑
                System.out.println("hello world");
                Thread.sleep(50);
            }catch (BlockException e) {
                System.out.println("blocking");
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (entry != null) {
                    entry.exit();//退出流控，该设置不可少
                }
            }
        }
    }

    private static void initFlowRules() {
        //流式规则，也就是流控规则
        List<FlowRule> rules = new ArrayList<FlowRule>();
        FlowRule rule = new FlowRule();
        //设置规则适用资源
        rule.setResource("HelloWorld");
        //流控方式，我们定义为QPS，也就是每秒访问数，也可以控制线程？
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(10);
        rules.add(rule);
        //添加规则,向规则管理注入定义规则。
        FlowRuleManager.loadRules(rules);
    }
}
