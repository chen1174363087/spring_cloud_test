package com.forezp.serviceapi.service.impl;

import com.forezp.serviceapi.service.UseServiceHi;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceHiImpl implements UseServiceHi {
    @Autowired
    RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "error") //较底层的服务如果出现故障，会导致连锁故障。
    // 当对特定的服务的调用的不可用达到一个阀值（Hystric 是5秒20次） 断路器将会被打开（调用error 方法）
    //fallbackMethod指定的方法的入参类型一定与该注解所注解的方法的参数一致
    public String useServiceHiByRibbon(String value) throws Exception {
        return restTemplate.getForObject("http://service-HI/hi?name=" + value, String.class);
    }

    /**
     * 断路器调用的方法
     *
     * @return
     */
    public String error(String name) {
        return "error!!!" + name;
    }
}
