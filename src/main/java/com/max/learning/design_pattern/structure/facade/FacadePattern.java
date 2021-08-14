package com.max.learning.design_pattern.structure.facade;

/**
 * @program: learning
 * @description: 外观模式
 * @author: Max.Tu
 * @create: 2021-08-14 23:59
 * 外观（Facade）模式是“迪米特法则”的典型应用，它有以下主要优点。
 * 降低了子系统与客户端之间的耦合度，使得子系统的变化不会影响调用它的客户类。
 * 对客户屏蔽了子系统组件，减少了客户处理的对象数目，并使得子系统使用起来更加容易。
 * 降低了大型软件系统中的编译依赖性，简化了系统在不同平台之间的移植过程，因为编译一个子系统不会影响其他的子系统，也不会影响外观对象。
 *
 * 外观（Facade）模式的主要缺点如下。
 * 不能很好地限制客户使用子系统类，很容易带来未知风险。
 * 增加新的子系统可能需要修改外观类或客户端的源代码，违背了“开闭原则”。
 **/
public class FacadePattern {
    //外观角色
    class Facade {
        private SubSystem01 obj1 = new SubSystem01();
        private SubSystem02 obj2 = new SubSystem02();
        private SubSystem03 obj3 = new SubSystem03();
        public void method() {
            obj1.method1();
            obj2.method2();
            obj3.method3();
        }
    }
    //子系统角色
    class SubSystem01 {
        public void method1() {
            System.out.println("子系统01的method1()被调用！");
        }
    }
    //子系统角色
    class SubSystem02 {
        public void method2() {
            System.out.println("子系统02的method2()被调用！");
        }
    }
    //子系统角色
    class SubSystem03 {
        public void method3() {
            System.out.println("子系统03的method3()被调用！");
        }
    }
}
