package com.max.design.create.abstract_factory.bugstack;

import com.max.design.create.abstract_factory.bugstack.utils.ClassLoaderUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2021-11-21 23:18
 **/
public class JDKProxy {

    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter cacheAdapter) throws Exception {
        InvocationHandler invocationHandler = new JDKInvocationHandler(cacheAdapter);
        ClassLoader loader = ClassLoaderUtil.getCurrentClassLoader();
        Class<?>[] classes = interfaceClass.getInterfaces();
        return (T) Proxy.newProxyInstance(loader, new Class[]{classes[0]}, invocationHandler);
    }
}
