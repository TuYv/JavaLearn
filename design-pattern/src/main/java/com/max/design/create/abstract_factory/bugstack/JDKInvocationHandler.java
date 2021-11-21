package com.max.design.create.abstract_factory.bugstack;

import com.max.design.create.abstract_factory.bugstack.utils.ClassLoaderUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2021-11-20 18:17
 **/
public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法名和入参类型
        return ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtil.getClazzByArgs(args)).invoke(cacheAdapter, args);
    }
}
