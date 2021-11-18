package com.max.design.create.abstract_factory.bugstack.cuisine.impl;

import com.max.design.create.abstract_factory.bugstack.CacheService;
import com.max.design.create.abstract_factory.bugstack.RedisUtils;
import java.util.concurrent.TimeUnit;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2021-11-18 22:58
 **/
public class CacheServiceImpl implements CacheService {

    private RedisUtils redisUtils = new RedisUtils();

    @Override
    public String get(String key) {
        return redisUtils.get(key);
    }

    @Override
    public void set(String key, String value) {
        redisUtils.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        redisUtils.set(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        redisUtils.del(key);
    }
}
