### nacos与springcloud整合

#### 1、配置整合

```xml
    <dependency>
        <groupId>com.alibaba.cloud</groupId>
        <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        <version>2.2.4.RELEASE</version>
    </dependency>
```
nacos与springcloud的配置整合，最为简单，引入pom依赖，在使用时和spring原生使用一致，采用@Value注解即可。如果需要实时刷新需要添加@RefreshScope注解

我们需要在resource/bootstrap.yml 配置文件，尽量采用bootstrap.yml，使用application.yml有部分配置不生效。配置内容
```yaml
spring:
  cloud:
    nacos:
      config:
        file-extension: yaml # 即是文件类型，也是dataId的一部分，需要在bootstrap.yml中配置
        prefix: cloudone
      server-addr: localhost:8848
      discovery:
        server-addr: localhost:8848
```
这里及配置了配置服务器，也配置了服务注册与发现。这里需要注意的是file-extension即是定义了dataId也是说明了配置中心中，配置文件的类型，这里如果不设置，默认是properties，这时，配置中心采用yaml是无效的。
dataId的规则是{prefix(默认是服务名)}-{active}.{file-extension};如果不指定active，那么就是prefix.file-extension

### 2、服务发现
```xml
    <dependency>
        <groupId>com.alibaba.cloud</groupId>
        <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        <version>2.2.4.RELEASE</version>
    </dependency>
```
服务发现，只需要引入pom依赖，并添加@EnableDiscoveryClient注解即可。配置文件中，指定服务注册与发现中心地址。默认情况下以application.name为服务名。我们后续访问即可通过服务名来访问。

