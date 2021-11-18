package com.max.design.create.abstract_factory.bugstack.impl;

import com.max.design.create.abstract_factory.bugstack.ICacheAdapter;
import com.max.design.create.abstract_factory.bugstack.matter.IIR;
import java.util.concurrent.TimeUnit;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2021-11-18 23:27
 **/
public class IIRCacheAdapter implements ICacheAdapter {
    private IIR iIR = new IIR();
    @Override
    public String get(String key) {
        return iIR.get(key);
    }

    @Override
    public void set(String key, String value) {
        iIR.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iIR.setExpire(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        iIR.del(key);
    }
}
