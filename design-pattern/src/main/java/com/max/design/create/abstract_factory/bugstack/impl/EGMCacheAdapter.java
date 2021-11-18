package com.max.design.create.abstract_factory.bugstack.impl;

import com.max.design.create.abstract_factory.bugstack.ICacheAdapter;
import com.max.design.create.abstract_factory.bugstack.matter.EGM;
import java.util.concurrent.TimeUnit;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2021-11-18 23:22
 **/
public class EGMCacheAdapter implements ICacheAdapter {

    private EGM egm = new EGM();
    @Override
    public String get(String key) {
        return egm.gain(key);
    }

    @Override
    public void set(String key, String value) {
        egm.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        egm.delete(key);
    }
}
