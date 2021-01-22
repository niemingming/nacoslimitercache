package com.nmm.study.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheTestController {


    /**
     * 测试缓存，默认的key应该是参数，或者说第一个参数，或者参数的组合。最大可能是参数的组合或者hash值，
     * 我们复杂情况下，我们指定key值最好。
     *
     * @param name
     * @return
     */
    @GetMapping("/cache/{name}")
    @Cacheable(value = "testone",keyGenerator = "keyGenerator")
    public String cachetest(@PathVariable String name) {
        System.out.println("执行方法！");
        return "hello " + name;
    }

}
