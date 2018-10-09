package com.jc.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * http://localhost:8888/foo/dev
 * http://localhost:8888/appName/profileName
 *
 * 证明配置服务中心可以从远程程序获取配置信息。
 * http请求地址和资源文件映射如下:
 *
 * /{application}/{profile}[/{label}]
 * /{application}-{profile}.yml
 * /{label}/{application}-{profile}.yml
 * /{application}-{profile}.properties
 * /{label}/{application}-{profile}.properties
 *
 * ---------------------
 *
 * 本文来自 方志朋 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/forezp/article/details/81041028?utm_source=copy
 */
@SpringBootApplication
@EnableConfigServer // 开启配置服务器的功能
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
