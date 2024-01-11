package com.rick.springcloud.controller;

import cn.hutool.json.JSONUtil;
import com.rick.springcloud.annotation.scope.ScopedService;
import com.rick.springcloud.dto.DemoDTO;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Resource
    DemoDTO user;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @PreAuthorize("hasRole('admin')")
    public String hello() {
        return "hello world";
    }

    public void scope() {
        System.out.println(JSONUtil.toJsonStr(user));
    }
}
