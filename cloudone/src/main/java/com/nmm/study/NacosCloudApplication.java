package com.nmm.study;

import com.alibaba.nacos.api.annotation.NacosProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // 允许服务发现和注册
public class NacosCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosCloudApplication.class,args);
    }
}
