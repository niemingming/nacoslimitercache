package com.nmm.study.guava.limit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 请求限流注解，基于Guava的Ratelimiter+AOP，这种方式只能实现单实例，集群需要结合sentinel来实现。
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequestLimit {

    int value() default 20;//默认的每秒限流数

    String name(); //限流名称，用于区分不同请求的限流。

}
