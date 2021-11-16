package com.max.design.structure.decorator;

/**
 * @program: learning
 * @description: 装饰器模式
 * @author: Max.Tu
 * @create: 2021-08-14 23:56
 * 装饰器模式的主要优点有：
 * 装饰器是继承的有力补充，比继承灵活，在不改变原有对象的情况下，动态的给一个对象扩展功能，即插即用
 * 通过使用不用装饰类及这些装饰类的排列组合，可以实现不同效果
 * 装饰器模式完全遵守开闭原则
 *
 * 其主要缺点是：装饰器模式会增加许多子类，过度使用会增加程序得复杂性。
 **/
public class DecoratorPattern {

    //抽象构件角色
    interface Component {
        public void operation();
    }
    //具体构件角色
    class ConcreteComponent implements Component {
        public ConcreteComponent() {
            System.out.println("创建具体构件角色");
        }
        public void operation() {
            System.out.println("调用具体构件角色的方法operation()");
        }
    }
    //抽象装饰角色
    class Decorator implements Component {
        private Component component;
        public Decorator(Component component) {
            this.component = component;
        }
        public void operation() {
            component.operation();
        }
    }
    //具体装饰角色
    class ConcreteDecorator extends Decorator {
        public ConcreteDecorator(Component component) {
            super(component);
        }
        public void operation() {
            super.operation();
            addedFunction();
        }
        public void addedFunction() {
            System.out.println("为具体构件角色增加额外的功能addedFunction()");
        }
    }
}
