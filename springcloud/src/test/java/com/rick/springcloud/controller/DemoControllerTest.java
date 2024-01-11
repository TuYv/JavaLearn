package com.rick.springcloud.controller;

import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Rick.Tu
 * @program JavaLearn
 * @description
 * @create 2024-01-10 23:29
 **/
@SpringBootTest
public class DemoControllerTest {
    @Resource DemoController demoController;
    @Test
    public void test() {
        demoController.scope();
        demoController.scope();
        demoController.scope();
    }
}
