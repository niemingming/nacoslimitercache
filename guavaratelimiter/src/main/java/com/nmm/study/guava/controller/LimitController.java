package com.nmm.study.guava.controller;

import com.nmm.study.guava.limit.RequestLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {


    @GetMapping("/limit")
    @RequestLimit(value = 10,name = "limit")
    public String limitTest() throws InterruptedException {
        //耗时长一点
        Thread.sleep(1000);
        return "hello";
    }

}
