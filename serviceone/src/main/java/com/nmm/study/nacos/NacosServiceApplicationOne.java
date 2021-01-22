package com.nmm.study.nacos;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableNacosDiscovery
@NacosPropertySource(dataId = "serviceone",autoRefreshed = true) // 配置中心配置。
public class NacosServiceApplicationOne {

    public static void main(String[] args) {
        SpringApplication.run(NacosServiceApplicationOne.class,args);
    }
}
