package com.max.design.behavioral.observer.event.listener;

import com.max.design.behavioral.observer.LotteryResult;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Rick
 * @date 2021-12-06 21:53
 */
@Slf4j
public class MessageEventListener implements EventListener{
    @Override public void doEvent(LotteryResult result) {
        log.info("给用户 {} 发送短信通知(短信)：{}", result.getUId(), result.getMessage());
    }
}
