package com.forezp.serviceapi.service.impl;

import com.forezp.serviceapi.service.UseServiceHiByFeign;
import org.springframework.stereotype.Service;

@Service
public class UseServiceHiByFeignImpl implements UseServiceHiByFeign{
    @Override
    public String useServiceHiByFeign(String value) throws Exception {
        return "error by feign";
    }
}
