package com.max.design.create.abstract_factory.bugstack.utils;

import cn.hutool.core.util.ClassUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2021-11-20 18:19
 **/
public class ClassLoaderUtil {
    private static Set<Class> primitiveSet = new HashSet<Class>();

    static {
        primitiveSet.add(Integer.class);
        primitiveSet.add(Long.class);
        primitiveSet.add(Float.class);
        primitiveSet.add(Byte.class);
        primitiveSet.add(Short.class);
        primitiveSet.add(Double.class);
        primitiveSet.add(Character.class);
        primitiveSet.add(Boolean.class);
    }

    /**
     * 获取当前ClassLoader
     * @return
     */
    public static ClassLoader getCurrentClassLoader() {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if(cl == null) {
            cl = ClassLoaderUtil.class.getClassLoader();
        }
        return  cl == null ? ClassLoader.getSystemClassLoader() : cl;
    }

    /**
     * 获取当前ClassLoader
     * @param clazz
     * @return
     */
    public static ClassLoader getClassLoader(Class<?> clazz) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if (loader != null) {
            return loader;
        }
        if (clazz != null) {
            loader = clazz.getClassLoader();
        }
        return loader == null ? ClassLoader.getSystemClassLoader() :loader;
    }

    /**
     * 根据类名加载Class
     * @param className
     * @return
     * @throws ClassNotFoundException
     */
    public static Class forName(String className) throws ClassNotFoundException{
        return forName(className, true);
    }

    /**
     * 根据类名加载Class
     * @param className
     * @param initialize
     * @return
     * @throws ClassNotFoundException
     */
    public static Class forName(String className, boolean initialize) throws ClassNotFoundException{
        return Class.forName(className, initialize, getCurrentClassLoader());
    }

    public static <T> T newInstance(Class<T> clazz) throws Exception {
        if (primitiveSet.contains(clazz)) {
            return null;
        }
        if (clazz.isMemberClass() && !Modifier.isStatic(clazz.getModifiers())) {
            Constructor constructorList[] = clazz.getConstructors();
            Constructor defaultConstructor = null;
            for (Constructor constructor : constructorList) {
                if (constructor.getParameterTypes().length == 1) {
                    defaultConstructor = constructor;
                    break;
                }
            }
            if (defaultConstructor == null) {
                throw new Exception("The " + clazz.getCanonicalName() + " has no default constructor!");
            } else {
                boolean accessible = defaultConstructor.isAccessible();
                try {
                    defaultConstructor.setAccessible(true);
                    return (T) defaultConstructor.newInstance(new Object[] {null});
                } finally {
                    defaultConstructor.setAccessible(accessible);
                }
            }
        }
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            boolean accessible = constructor.isAccessible();
            try {
                constructor.setAccessible(true);
                return (T) constructor.newInstance(new Object[] {null});
            } finally {
                constructor.setAccessible(accessible);
            }
        }
    }


    public static Class<?>[] getClazzByArgs(Object[] args) {
        Class<?>[] parameterTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ArrayList) {
                parameterTypes[i] = List.class;
                continue;
            }
            if (args[i] instanceof LinkedList) {
                parameterTypes[i] = List.class;
                continue;
            }
            if (args[i] instanceof HashMap) {
                parameterTypes[i] = Map.class;
                continue;
            }
            if (args[i] instanceof Long){
                parameterTypes[i] = long.class;
                continue;
            }
            if (args[i] instanceof Double){
                parameterTypes[i] = double.class;
                continue;
            }
            if (args[i] instanceof TimeUnit){
                parameterTypes[i] = TimeUnit.class;
                continue;
            }
            parameterTypes[i] = args[i].getClass();
        }
        return parameterTypes;
    }

    public Method getMethod(Class<?> classType, String methodName, Class<?>... parameterTypes) throws NoSuchMethodException {
        return classType.getMethod(methodName, parameterTypes);
    }
}
