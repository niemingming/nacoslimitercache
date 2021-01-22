
### 1、[cache注解说明][1]

### 2、springcache实现了基于注解的处理，我们通过设置cachemanager来指定采用什么做缓存，默认的自带的是基于内存的缓存处理，我们也可以通过引入redis，设置RedisCacheManager来指定其缓存为redis。同时我们还可以设置缓存key生成器，缓存内容处理器。

默认原生的缓存，我们需要在添加配置，配置CacheManager，同时指定EnableCaching
我们还需要初始化所有的cache,我们指定cache。



[1]:https://www.cnblogs.com/wenjunwei/p/10779450.html