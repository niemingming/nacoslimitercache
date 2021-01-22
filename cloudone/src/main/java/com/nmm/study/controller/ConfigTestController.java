package com.nmm.study.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope // 刷新参数
public class ConfigTestController {
    @Value("${spring.datasource.url:none}")
    private String url;

    @GetMapping("/configs")
    public String getUrl(){
        System.out.println(url);
        return url;
    }
}
