package com.forezp.serviceapi.controller;

import com.forezp.serviceapi.service.UseServiceHi;
import com.forezp.serviceapi.service.UseServiceHiByFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UseServiceHiController {
    @Autowired
    private UseServiceHi useServiceHi;


    @Autowired
    private UseServiceHiByFeign useServiceHiByFeign;

    @RequestMapping(value = "/test/{value}" , method = RequestMethod.GET)
    public String test(@PathVariable("value") String value){
        String result=null;
        try {
            result = useServiceHi.useServiceHiByRibbon(value);
            result = useServiceHiByFeign.useServiceHiByFeign(value);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
