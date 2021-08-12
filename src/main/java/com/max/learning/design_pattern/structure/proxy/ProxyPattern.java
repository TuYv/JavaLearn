package com.max.learning.design_pattern.structure.proxy;

/**
 * @author max
 * @description: 代理模式
 * @date 2021/8/12 20:38
 * 代理模式的定义：由于某些原因需要给某对象提供一个代理以控制对该对象的访问。这时，访问对象不适合或者不能直接引用目标对象，代理对象作为访问对象和目标对象之间的中介。
 *
 * 代理模式的主要优点有：
 * 代理模式在客户端与目标对象之间起到一个中介作用和保护目标对象的作用；
 * 代理对象可以扩展目标对象的功能；
 * 代理模式能将客户端与目标对象分离，在一定程度上降低了系统的耦合度，增加了程序的可扩展性
 * 其主要缺点是：
 * 代理模式会造成系统设计中类的数量增加
 * 在客户端和目标对象之间增加一个代理对象，会造成请求处理速度变慢；
 * 增加了系统的复杂度；
 *
 * 在代码中，一般代理会被理解为代码增强，实际上就是在原代码逻辑前后增加一些代码逻辑，而使调用者无感知。
 *
 * 根据代理的创建时期，代理模式分为静态代理和动态代理。
 * 静态：由程序员创建代理类或特定工具自动生成源代码再对其编译，在程序运行前代理类的 .class 文件就已经存在了。
 * 动态：在程序运行时，运用反射机制动态创建而成
 */
public class ProxyPattern {
    interface Subject {
       void request();
    }

    class RealSubject implements Subject {
        @Override
        public void request() {
            System.out.println("访问真实主题方法....");
        }
    }

    class Proxy implements Subject {
        private RealSubject realSubject;
        @Override
        public void request() {
            if (realSubject == null) {
                realSubject = new RealSubject();
            }
            preRequest();
            realSubject.request();
            postRequest();
        }
        public void preRequest() {
            System.out.println("访问真实主题之前的预处理。");
        }
        public void postRequest() {
            System.out.println("访问真实主题之后的后续处理。");
        }
    }
}
