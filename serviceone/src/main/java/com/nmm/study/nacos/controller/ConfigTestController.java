package com.nmm.study.nacos.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigTestController {

    @NacosValue(value = "${spring.datasource.test:NONE}",autoRefreshed = true)
    private String test;
    @NacosValue(value = "${spring.datasource.username:none}",autoRefreshed = true)
    private String username;
    @NacosValue(value = "${spring.datasource.password:none}",autoRefreshed = true)
    private String password;


    @GetMapping("/configs")
    public String getValue(){
        System.out.println("test: " + test);
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        return test;
    }


}
