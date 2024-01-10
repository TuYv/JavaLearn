package com.rick.springcloud.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rick.Tu
 * @program JavaLearn
 * @description
 * @create 2022-10-26 21:43
 **/
@RestController
public class DemoController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @PreAuthorize("hasRole('admin')")
    public String hello() {
        return "hello world";
    }
}
