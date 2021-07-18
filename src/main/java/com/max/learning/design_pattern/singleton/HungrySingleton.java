package com.max.learning.design_pattern.singleton;

/**
 * 饿汉式单例模式
 * @author max
 * @date 2021/7/8 16:45
 */
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }

}
