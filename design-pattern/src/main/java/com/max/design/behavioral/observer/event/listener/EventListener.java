package com.max.design.behavioral.observer.event.listener;

import com.max.design.behavioral.observer.LotteryResult;

/**
 * @author Rick
 * @date 2021-12-06 21:50
 */
public interface EventListener {
    void doEvent(LotteryResult result);
}
