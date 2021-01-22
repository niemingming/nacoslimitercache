package com.nmm.study.cache.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@EnableCaching
@Configuration
public class CacheConfiguration {

    @Bean
    public CacheManager cacheManager(){
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("testone")));
        return cacheManager;
    }

    @Bean
    public KeyGenerator keyGenerator(){
        return (target,method,params) -> {
            System.out.println("key值生成");
            if (params == null) {
                return method.getName();
            }
            return params[0].toString().hashCode();
        };
    }

}
