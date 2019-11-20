package com.teacherblitz.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.teacherblitz.entity.TUser;
import com.teacherblitz.feignclient.TestUserCenterFeignClient;
import com.teacherblitz.sentinel.handler.BlockExceptionHandler;
import com.teacherblitz.sentinel.handler.FallbackExceptionHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author teacherblitz
 * @since 2019/10/20 21:43
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class TestUserCenterController {

    private final TestUserCenterFeignClient testUserCenterFeignClient;

    @RequestMapping("/getUser")
    public TUser getUser(TUser tUser){
        return this.testUserCenterFeignClient.getUserInfo(tUser);
    }

    /**
     * 测试sentinel热点规则
     * @param a
     * @param b
     * @return
     */
    @RequestMapping("test-a")
    @SentinelResource("hot")
    public String testA(@RequestParam(required = false) String a,@RequestParam(required = false) String b){
        return a + " " + b;
    }

    /**
     * 测试自定义流控规则
     * @return
     */
    @RequestMapping("test-add-flow-rule")
    public String testAddFlowRule(){
        this.initFlowQpsRule();
        return "success";
    }

    private void initFlowQpsRule() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule("getContentInfo/1");
        // set limit qps to 2
        rule.setCount(2);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

    /**
     * sentinel api
     * @param a
     * @return
     */
    @GetMapping("test-sentinel-resource")
    @SentinelResource(value = "test-sentinel-api",
            blockHandler = "block", blockHandlerClass = BlockExceptionHandler.class,
            fallback = "fallback", fallbackClass = FallbackExceptionHandler.class)
    public String testSentinelResource(@RequestParam(required = false) String a){
        if(StringUtils.isEmpty(a)){
            throw new IllegalArgumentException("参数a不能为空");
        }
        return a;
    }


    private final RestTemplate restTemplate;

    /**
     * rest template整合sentinel
     * @param id
     * @return
     */
    @RequestMapping("test-rest-template-sentinel/{id}")
    public TUser testRestTemplateSentinel(@PathVariable Integer id){
        return this.restTemplate.getForObject("http://user-center/getUserInfo/{id}",TUser.class,id);
    }

    private final Source source;

    /**
     * 测试stream发送消息
     * @return
     */
    @RequestMapping("/test-stream")
    public String testStream(){
        source.output().send(
                MessageBuilder
                        .withPayload("消息体")
                        .build()
        );
        return "success";
    }

}
