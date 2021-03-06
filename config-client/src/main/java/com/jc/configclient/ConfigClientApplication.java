package com.jc.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientApplication {

    /**
     * 消息总线刷新配置文件
     * http://localhost:8881/actuator/bus-refresh
     * 这是Spring cloud bus提供的endpoint，名字不能改
     *
     * 另外，/actuator/bus-refresh接口可以指定服务，即使用"destination"参数，
     * 比如 “/actuator/bus-refresh?destination=customers:**” 即刷新服务名为customers的所有服务。
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Value("${foo}")
    String foo;

    /**
     * http://localhost:8881/hi
     * 返回从配置中心读取的foo变量的值
     * @return
     */
    @RequestMapping("/hi")
    public String hi(){
        return foo;
    }
}
