参考资料：

一、[Spring Cloud 官网Tutorial](http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/single/spring-cloud.html)

二、[史上最简单的 SpringCloud 教程-方志朋](https://blog.csdn.net/forezp/article/details/70148833)

    版本：Spring Cloud Finchley.SR1; Spring Boot 2.0.5.RELEASE；IDEA Ultimate 2018.1

* [第一篇: 服务的注册与发现（Eureka）](https://blog.csdn.net/forezp/article/details/81040925)

    - [eureka-server](https://github.com/litangbo/sc-f-chapter1/tree/master/eureka-server)     新建module，服务注册中心 eureka server 8761
        - http://localhost:8761/
    - [service-ui](https://github.com/litangbo/sc-f-chapter1/tree/master/service-ui)        新建module，服务提供者 eureka client 8762
        - http://localhost:8762/hi?name=ltb
        - http://localhost:8762/hi

* [第二篇: 服务消费者（rest+ribbon）](https://blog.csdn.net/forezp/article/details/81040946)

    - [service-ui](https://github.com/litangbo/sc-f-chapter1/tree/master/service-ui)        [修改端口，启动多个实例](https://blog.csdn.net/forezp/article/details/76408139) 8763
    - [service-ribbon](https://github.com/litangbo/sc-f-chapter1/tree/master/service-ribbon)    新建module，服务消费者 8764
        - http://localhost:8764/hi?name=ltb 多次访问，自动负载均衡

* [第三篇: 服务消费者（Feign）](https://blog.csdn.net/forezp/article/details/81040965)

    - [service-feign](https://github.com/litangbo/sc-f-chapter1/tree/master/service-feign)     新建module，服务消费者 8765
        - http://localhost:8764/hi?name=ltb 多次访问，自动负载均衡

* [第四篇:断路器（Hystrix）](https://blog.csdn.net/forezp/article/details/81040990)

    - 关掉8762或8763端口服务
    - [service-ribbon](https://github.com/litangbo/sc-f-chapter1/tree/master/service-ribbon)    改写代码，重启，在ribbon中使用断路器 8764
        - http://localhost:8764/hi?name=ltb 若访问服务断掉，则进行快速熔断
    - [service-feign](https://github.com/litangbo/sc-f-chapter1/tree/master/service-feign)     改写代码，重启，在feign中使用断路器 8765
        - http://localhost:8764/hi?name=ltb 若访问服务断掉，则进行快速熔断

* [第五篇: 路由网关(zuul)](https://blog.csdn.net/forezp/article/details/81041012)

    - [service-zuul](https://github.com/litangbo/sc-f-chapter1/tree/master/service-zuul)      新建module，路由转发和过滤器 8769

* [第六篇: 分布式配置中心(Spring Cloud Config)](https://blog.csdn.net/forezp/article/details/81041028)

    - [config-server](https://github.com/litangbo/sc-f-chapter1/tree/master/config-server)      新建module，配置服务中心 8888
        - http://localhost:8888/appName/profileName
    - [config-client](https://github.com/litangbo/sc-f-chapter1/tree/master/config-client)      新建module，配置客户端 8881
        - http://localhost:8881/hi

* [第七篇: 高可用的分布式配置中心(Spring Cloud Config)](https://blog.csdn.net/forezp/article/details/81041045)

    - [eureka-server](https://github.com/litangbo/sc-f-chapter1/tree/master/eureka-server)      保持不变，服务注册中心 eureka server 8761
        - http://localhost:8761/
    - [config-server](https://github.com/litangbo/sc-f-chapter1/tree/master/config-server)      改写yml文件，添加服务注册中心地址，配置服务中心 8888
    - [config-client](https://github.com/litangbo/sc-f-chapter1/tree/master/config-client)      改写yml文件，添加服务注册中心地址，配置客户端 8881
        - http://localhost:8881/hi

* [第八篇: 消息总线(Spring Cloud Bus)](https://blog.csdn.net/forezp/article/details/81041062)

    - [RabbitMQ官网](http://www.rabbitmq.com/)
    - [RabbitMQ入门使用](https://www.cnblogs.com/SFLYQ/p/7358283.html)
    - [config-client](https://github.com/litangbo/sc-f-chapter1/tree/master/config-client)      麻烦！！！在properties文件中配置，用POSTMAN提交刷新请求http://localhost:8881/actuator/bus-refresh
        - http://localhost:8881/hi

* [第九篇: 服务链路追踪(Spring Cloud Sleuth)](https://blog.csdn.net/forezp/article/details/81041078)

* [第十篇: 高可用的服务注册中心](https://blog.csdn.net/forezp/article/details/81041101)

* [第十二篇: 断路器监控(Hystrix Dashboard)](https://blog.csdn.net/forezp/article/details/81041113)

* [第十三篇: 断路器聚合监控(Hystrix Turbine)](https://blog.csdn.net/forezp/article/details/81041125)
