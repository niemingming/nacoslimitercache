package com.nmm.study.guava.local;

import com.google.common.cache.CacheBuilder;
import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterTest {

    static int line = 1;

    public static void main(String[] args) throws InterruptedException {
        //每秒20个
        final RateLimiter limiter = RateLimiter.create(20);
//        limiter.acquire();//会阻塞
        //多线程的锁定
//        for (int i = 0; i < 1000; i++) {
//
//            new Thread(){
//                @Override
//                public void run() {
//                    if (limiter.tryAcquire()) {
//                        System.out.println("获取执行成功。" + line++);
//                    }else {
//                        System.out.println("获取执行失败。" + line++);
//                    }
//                }
//            }.start();
//        }
        //单线程的任务限流
        //从这里可以验证，ratelimiter是有一个爬升时间的，不会一下子就满的。所以我们可以指定超时时间，用于令牌桶的初始化。
        while (true) {
            if (line%100 == 0) {
                Thread.sleep(1000);
            }
            if (line > 2000) {
                break;
            }
            if (limiter.tryAcquire()) {
                System.out.println("获取执行成功。" + line++);
            }else {
                System.out.println("获取执行失败。" + line++);
            }
        }
    }

}
