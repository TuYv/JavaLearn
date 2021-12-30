package com.max.design.behavioral.observer.event;

import com.max.design.behavioral.observer.event.listener.EventListener;
import jdk.jfr.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rick
 * @date 2021-12-06 21:47
 */
public class EventManager {

    Map<Enum<EventType>, List<EventListener>> listeners = new HashMap<>();

    public EventManager(Enum<EventType>... operations) {
        for (Enum<EventType> operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }








    public enum EventType {
        MQ, Message
    }
}
