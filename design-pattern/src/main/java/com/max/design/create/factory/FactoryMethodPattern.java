package com.max.design.create.factory;


import com.max.design.create.factory.product.ConcreteProduct1;
import com.max.design.create.factory.product.ConcreteProduct2;
import com.max.design.create.factory.product.Product;

/**
 * @program: learning
 * @description: 工厂方法模式
 * @author: Max.Tu
 * @create: 2021-07-18 14:03
 * 优点：
 * 用户只需要知道具体工厂的名称就可得到所要的产品，无须知道产品的具体创建过程。
 * 灵活性增强，对于新产品的创建，只需多写一个相应的工厂类。
 * 典型的解耦框架。高层模块只需要知道产品的抽象类，无须关心其他实现类，满足迪米特法则、依赖倒置原则和里氏替换原则。
 * 缺点：
 * 类的个数容易过多，增加复杂度
 * 增加了系统的抽象性和理解难度
 * 抽象产品只能生产一种产品，此弊端可使用抽象工厂模式解决。
 **/
public class FactoryMethodPattern {
    interface AbstractFacotry{
        public Product newProduct();
    }
    static class ConcreteFactory1 implements AbstractFacotry {

        @Override
        public Product newProduct() {
            System.out.println("具体工厂1生成-->具体产品1...");
            return new ConcreteProduct1();
        }
    }
    static class ConcreteFactory2 implements AbstractFacotry {

        @Override
        public Product newProduct() {
            System.out.println("具体工厂2生成-->具体产品2...");
            return new ConcreteProduct2();
        }
    }

    public static void main(String[] args) {
        AbstractFacotry af1 = new ConcreteFactory1();
        AbstractFacotry af2 = new ConcreteFactory2();

        Product p1 = af1.newProduct();
        Product p2 = af2.newProduct();

        p1.show();
        p2.show();

    }
}
