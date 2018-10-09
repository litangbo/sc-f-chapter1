package com.jc.servicefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 疑问：@RequestMapping和@RequestParam两个注解为什么在Service和Controller中都存在？
 */
@RestController
public class HiController {

    // org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'hiController':
    // Unsatisfied dependency expressed through field 'schedualServiceHi';
    // nested exception is org.springframework.beans.factory.BeanCreationException:
    // Error creating bean with name 'com.jc.servicefeign.ScheduleServiceHi':
    // FactoryBean threw exception on object creation; nested exception is java.lang.IllegalStateException:
    // No fallback instance of type class com.jc.servicefeign.ScheduleServiceHiHystric found for feign client service-hi

    // 编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired(required = false)
    ScheduleServiceHi scheduleServiceHi;

    /**
     * http://localhost:8765/hi
     * http://localhost:8765/hi?name=ltb
     * @param name
     * @return
     */
    // @RequestMapping(value = "/hi", method = RequestMethod.GET)
    @GetMapping("/hi")
    public String sayHi(@RequestParam(defaultValue = "LiTangBo") String name){
        return scheduleServiceHi.sayHiFromClientOne(name);
    }
}
