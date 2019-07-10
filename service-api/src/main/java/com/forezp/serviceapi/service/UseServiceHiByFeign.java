package com.forezp.serviceapi.service;

import com.forezp.serviceapi.service.impl.UseServiceHiByFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(serviceId = "service-hi", fallback = UseServiceHiByFeignImpl.class)
public interface UseServiceHiByFeign {
    String useServiceHiByFeign(String value) throws Exception;
}
