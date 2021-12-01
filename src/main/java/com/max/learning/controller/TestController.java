package com.max.learning.controller;

import com.max.learning.entity.TestDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Rick
 * @date 2021-11-28 13:17
 */
@RestController
@RequestMapping("/roomLock")
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public TestDTO testController() {
        TestDTO testDTO = new TestDTO();
        testDTO.setTime(new Date());
        return testDTO;
    }
}
