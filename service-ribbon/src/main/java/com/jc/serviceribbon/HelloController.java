package com.jc.serviceribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    /**
     * http://localhost:8764/hi
     * http://localhost:8764/hi?name=ltb
     * @param name
     * @return
     */
    @GetMapping("/hi")
    public String hi(@RequestParam(defaultValue = "LiTangBo") String name){
        return helloService.hiService(name);
    }
}
