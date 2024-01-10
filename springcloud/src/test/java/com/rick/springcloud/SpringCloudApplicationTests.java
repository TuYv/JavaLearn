package com.rick.springcloud;


import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import cn.hutool.json.JSONUtil;
import com.rick.springcloud.api.DemoRemote;
import javax.annotation.Resource;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class SpringCloudApplicationTests {

    @Resource
    private DemoRemote demoRemote;
    private MockMvc mockMvc;
    @Resource
    WebApplicationContext wac;
    @Before("test()")
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void contextLoads() {
        System.out.println(demoRemote.hello());
    }

    @Test
    @WithMockUser(roles = "admin1")
    public void test() throws Exception {
        System.out.println("----------------");
        System.out.println("----------------");
        System.out.println("----------------");
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).apply(springSecurity()).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());
        System.out.println("----------------");
    }

}
