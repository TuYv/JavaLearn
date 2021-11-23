package com.max.design.structure.proxy;

import static org.junit.jupiter.api.Assertions.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
class ProxyPatternTest {

    @Test
    public void proxyPatternTest() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        UserDao userDao = beanFactory.getBean("userDao", UserDao.class);
        String res = userDao.queryUserInfo("100001");
        log.info("测试结果：{}", res);
    }
}