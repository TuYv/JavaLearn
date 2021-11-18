package com.max.design.create.abstract_factory.bugstack;

import java.util.concurrent.TimeUnit;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2021-11-18 23:22
 **/
public interface ICacheAdapter {
    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}
