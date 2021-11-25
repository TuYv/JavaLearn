package com.max.design.behavioral.responsibility;

import com.alibaba.fastjson.JSON;
import com.max.design.behavioral.responsibility.cuisine.impl.Level1AuthLink;
import com.max.design.behavioral.responsibility.cuisine.impl.Level2AuthLink;
import com.max.design.behavioral.responsibility.cuisine.impl.Level3AuthLink;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rick
 * @date 2021-11-25 21:49
 */
@Slf4j
class AuthServiceTest {
    @Test
    public void test_AuthLink() throws ParseException {
        AuthLink authLink = new Level3AuthLink("1000013", "王工")
            .appendNext(new Level2AuthLink("1000012", "张经理")
                .appendNext(new Level1AuthLink("1000011", "段总")));

        log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟三级负责人审批
        AuthService.auth("1000013", "1000998004813441");
        log.info("测试结果：{}", "模拟三级负责人审批，王工");
        log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟二级负责人审批
        AuthService.auth("1000012", "1000998004813441");
        log.info("测试结果：{}", "模拟二级负责人审批，张经理");
        log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟一级负责人审批
        AuthService.auth("1000011", "1000998004813441");
        log.info("测试结果：{}", "模拟一级负责人审批，段总");
        log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

    }

}