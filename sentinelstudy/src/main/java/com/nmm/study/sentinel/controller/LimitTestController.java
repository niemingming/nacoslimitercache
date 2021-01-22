package com.nmm.study.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 限流请求
 */
@RestController
public class LimitTestController {

    @GetMapping("/limit")
    @SentinelResource(value = "one",blockHandler = "blockHandlerException",fallback = "fallbackException")
    public String limit() {
        System.out.println("hello");
        return "hello";
    }

    public String blockHandlerException(BlockException e){
        System.out.println("block");
        //s：发生时间，e阻塞异常
        return "block";
    }
    public String fallbackException() {
        //其他异常
        System.out.println("fallback");
        return "fallback";
    }
}
