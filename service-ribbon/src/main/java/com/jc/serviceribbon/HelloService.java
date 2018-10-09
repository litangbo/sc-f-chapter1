package com.jc.serviceribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 在ribbon中使用断路器
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name){
        // 服务名与大小写无关（推荐大写），是service-hi模块里yml文件配置的应用名称：spring.application.name
        String url =
                // "http://SERVICE-HI/hi?name="+name;
                "http://service-hi/hi?name="+name;
        return restTemplate.getForObject(url,String.class);
    }

    /**
     * 当 service-hi 工程不可用的时候，service-ribbon调用 service-hi的API接口时，会执行快速失败，
     * 直接返回一组字符串，而不是等待响应超时，这很好的控制了容器的线程阻塞
     * @param name
     * @return
     */
    public String hiError(String name){
        return "hi "+name+",sorry, error!";
    }
}
