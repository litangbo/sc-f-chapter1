package com.jc.servicehi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供者
 *
 * 当client向server注册时，它会提供一些元数据，例如主机和端口，URL，主页等。
 * Eureka server 从每个client实例接收心跳消息。 如果心跳超时，则通常将该实例从注册server中删除。
 */
@SpringBootApplication
@EnableEurekaClient // 表明自己是一个eureka client
@RestController
public class ServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    /**
     * http://localhost:8762/hi
     * http://localhost:8762/hi?name=ltb
     * @param name
     * @return
     */
    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "LiTangBo") String name){
        return "Hi "+name+", i am from port: "+port;
    }

}
