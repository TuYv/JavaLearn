package com.max.design.behavioral.observer.event.listener;

import com.max.design.behavioral.observer.LotteryResult;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Rick
 * @date 2021-12-06 21:54
 */
@Slf4j
public class MQEventListener implements EventListener{
    @Override public void doEvent(LotteryResult result) {
        log.info("记录用户 {} 摇号结果(MQ)：{}", result.getUId(), result.getMessage());
    }
}
