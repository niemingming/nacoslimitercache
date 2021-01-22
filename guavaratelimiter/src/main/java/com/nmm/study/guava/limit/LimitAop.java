package com.nmm.study.guava.limit;

import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 做切面限流
 */
@Aspect
@Component
public class LimitAop {

    @Pointcut("@annotation(com.nmm.study.guava.limit.RequestLimit)")
    public void limitPointCut(){};

    public ConcurrentHashMap<String,RateLimiter> cache = new ConcurrentHashMap<String, RateLimiter>();

    /**
     * 拦截判断是否达到限流
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("limitPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        //获取注解信息
        MethodSignature methodSignature = (MethodSignature) point.getSignature();

        Method method = point.getTarget().getClass().getMethod(methodSignature.getName(),methodSignature.getParameterTypes());
        RequestLimit limit = method.getAnnotation(RequestLimit.class);
        String name = limit.name();
        int count = limit.value();
        if (name == null ) {
            name = method.getName();
        }
        //获取限流控制器
        RateLimiter rateLimiter = null;
        rateLimiter = cache.get(name);
        if (rateLimiter == null) {
            rateLimiter = RateLimiter.create(count);
            cache.put(name,rateLimiter);
        }
        if (rateLimiter.tryAcquire()) {
            System.out.println("限流允许");
            return point.proceed();
        }else {
            System.out.println("限流不允许");
            return "服务器忙，请稍后访问！" ;
        }
    }

}
