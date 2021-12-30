package com.max.design.behavioral.observer.event;

import com.max.design.behavioral.observer.LotteryResult;
import com.max.design.behavioral.observer.event.listener.MQEventListener;
import com.max.design.behavioral.observer.event.listener.MessageEventListener;

/**
 * @author Rick
 * @date 2021-12-30 19:36
 */
public abstract class LotteryService {
    private EventManager eventManager;

    public LotteryService() {
        eventManager = new EventManager(EventManager.EventType.MQ, EventManager.EventType.Message);
        eventManager.subscribe(EventManager.EventType.MQ, new MQEventListener());
        eventManager.subscribe(EventManager.EventType.Message, new MessageEventListener());
    }

    public LotteryResult draw(String uId) {
        LotteryResult result = doDraw(uId);
        eventManager.notify(EventManager.EventType.MQ, result);
        eventManager.notify(EventManager.EventType.Message, result);

        return result;
    }

    protected abstract LotteryResult doDraw(String uId);
}
