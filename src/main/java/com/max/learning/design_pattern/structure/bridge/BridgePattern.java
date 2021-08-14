package com.max.learning.design_pattern.structure.bridge;

/**
 * @program: learning
 * @description: 桥接模式
 * @author: Max.Tu
 * @create: 2021-08-14 23:34
 * 桥接（Bridge）模式的优点是：
 * 抽象与实现分离，扩展能力强
 * 符合开闭原则
 * 符合合成复用原则
 * 其实现细节对客户透明
 *
 * 缺点是：由于聚合关系建立在抽象层，要求开发者针对抽象化进行设计与编程，能正确地识别出系统中两个独立变化的维度，这增加了系统的理解与设计难度。
 **/
public class BridgePattern {

    //实现化角色
    interface Implementor {
        public void OperationImpl();
    }
    //具体实现化角色
    class ConcreteImplementorA implements Implementor {
        public void OperationImpl() {
            System.out.println("具体实现化(Concrete Implementor)角色被访问");
        }
    }
    //抽象化角色
    abstract class Abstraction {
        protected Implementor imple;
        protected Abstraction(Implementor imple) {
            this.imple = imple;
        }
        public abstract void Operation();
    }
    //扩展抽象化角色
    class RefinedAbstraction extends Abstraction {
        protected RefinedAbstraction(Implementor imple) {
            super(imple);
        }
        public void Operation() {
            System.out.println("扩展抽象化(Refined Abstraction)角色被访问");
            imple.OperationImpl();
        }
    }
}
