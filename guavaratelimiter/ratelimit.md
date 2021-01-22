### guava
RateLimiter是基于内存和进程了，不适合集群环境使用，更多的是保护单实例的安全性。而且不能区分客户端。除非我们基于客户端建立限流，这样内存的额外消耗就会比较多。






### 附件
1、[guava官方文档地址][1]


[1]:http://ifeve.com/guava-ratelimiter/