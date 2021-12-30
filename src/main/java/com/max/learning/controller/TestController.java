package com.max.learning.controller;

import com.max.learning.entity.TestDTO;
import com.max.learning.enums.ResultEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Rick
 * @date 2021-11-28 13:17
 */
@RestController
@RequestMapping("/roomLock")
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public List<TestDTO> testController() {
        TestDTO testDTO = new TestDTO();
        testDTO.setTime(new Date());
        testDTO.setResultEnum(ResultEnum.SUCCESS);
        List<TestDTO> list = new ArrayList<>();
        list.add(testDTO);
        return list;
    }

    @RequestMapping(value = "/enum", method = RequestMethod.GET)
    public ResultEnum testEnum() {
        return ResultEnum.SUCCESS;
    }
}
