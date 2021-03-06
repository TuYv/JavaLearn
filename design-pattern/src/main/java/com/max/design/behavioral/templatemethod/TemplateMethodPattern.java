package com.max.design.behavioral.templatemethod;

/**
 * @program: learning
 * @description: 模版设计模式
 * @author: Max.Tu
 * @create: 2021-08-16 22:42
 * 该模式的主要优点如下。
 * 它封装了不变部分，扩展可变部分。它把认为是不变部分的算法封装到父类中实现，而把可变部分算法由子类继承实现，便于子类继续扩展。
 * 它在父类中提取了公共的部分代码，便于代码复用。
 * 部分方法是由子类实现的，因此子类可以通过扩展方式增加相应的功能，符合开闭原则。
 *
 * 该模式的主要缺点如下。
 * 对每个不同的实现都需要定义一个子类，这会导致类的个数增加，系统更加庞大，设计也更加抽象，间接地增加了系统实现的复杂度。
 * 父类中的抽象方法由子类实现，子类执行的结果会影响父类的结果，这导致一种反向的控制结构，它提高了代码阅读的难度。
 * 由于继承关系自身的缺点，如果父类添加新的抽象方法，则所有子类都要改一遍。
 **/
public class TemplateMethodPattern {

    //抽象类
    abstract class AbstractClass {
        //模板方法
        public void TemplateMethod() {
            SpecificMethod();
            abstractMethod1();
            abstractMethod2();
        }
        //具体方法
        public void SpecificMethod() {
            System.out.println("抽象类中的具体方法被调用...");
        }
        //抽象方法1
        public abstract void abstractMethod1();
        //抽象方法2
        public abstract void abstractMethod2();
    }
    //具体子类
    class ConcreteClass extends AbstractClass {
        public void abstractMethod1() {
            System.out.println("抽象方法1的实现被调用...");
        }
        public void abstractMethod2() {
            System.out.println("抽象方法2的实现被调用...");
        }
    }
}
