package com.max.design.structure.proxy.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2021-11-23 23:37
 **/
@Slf4j
@AllArgsConstructor
public class MapperFactoryBean<T> implements FactoryBean<T> {

    private Class<T> mapperInterface;

    @Override
    public T getObject() throws Exception {
        InvocationHandler handler = ((proxy, method, args) -> {
           Select select = method.getAnnotation(Select.class);
           log.info("sql: {}", select.value().replace("#{uId}", args[0].toString()));
           return args[0] + "wahahahah";
        });

        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{mapperInterface}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
