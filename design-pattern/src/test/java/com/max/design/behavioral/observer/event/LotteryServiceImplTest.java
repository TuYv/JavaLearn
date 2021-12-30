package com.max.design.behavioral.observer.event;

import com.alibaba.fastjson.JSON;
import com.max.design.behavioral.observer.LotteryResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rick
 * @date 2021-12-30 19:44
 */
@Slf4j
class LotteryServiceImplTest {

    @Test void doDraw() {
        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult result = lotteryService.draw("2765789109876");
        log.info("测试结果：{}", JSON.toJSONString(result));
    }
}