package com.rick.springcloud;

import com.rick.springcloud.api.DemoRemote;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringcloudApplicationTests {

    @Resource
    private DemoRemote demoRemote;

    @Test
    void contextLoads() {
        System.out.println(demoRemote.hello());
    }

}
