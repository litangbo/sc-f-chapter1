package com.jc.servicefeign;

import org.springframework.stereotype.Component;

/**
 * 需要实现ScheduleServiceHi 接口，并注入到IoC容器中
 *
 * stereotype 固定形式；老一套；陈规旧习；旧规矩；模式化概念（或形象）；刻板印象；    一板一眼；墨守成规
 */
@Component
public class ScheduleServiceHiHystrix implements ScheduleServiceHi{
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
