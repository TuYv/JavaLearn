package com.rick.springcloud.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="spring-cloud-demo")
public interface DemoRemote {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello();
}
