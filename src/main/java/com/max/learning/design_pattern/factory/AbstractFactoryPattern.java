package com.max.learning.design_pattern.factory;

import com.max.learning.design_pattern.factory.product.ConcreteProduct1;
import com.max.learning.design_pattern.factory.product.ConcreteProduct11;
import com.max.learning.design_pattern.factory.product.ConcreteProduct2;
import com.max.learning.design_pattern.factory.product.ConcreteProduct21;
import com.max.learning.design_pattern.factory.product.Product;
import com.max.learning.design_pattern.factory.product.Product2;

/**
 * @program: learning
 * @description: 抽象工厂模式
 * @author: Max.Tu
 * @create: 2021-07-18 14:53
 * 抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只生产一个等级的产品，而抽象工厂模式可生产多个等级的产品。
 *
 * 使用抽象工厂模式一般要满足以下条件。
 * 系统中有多个产品族，每个具体工厂创建同一族但属于不同等级结构的产品。
 * 系统一次只可能消费其中某一族产品，即同族的产品一起使用。
 *
 * 抽象工厂模式除了具有工厂方法模式的优点外，其他主要优点如下。
 * 可以在类的内部对产品族中相关联的多等级产品共同管理，而不必专门引入多个新的类来进行管理。
 * 当需要产品族时，抽象工厂可以保证客户端始终只使用同一个产品的产品组。
 * 抽象工厂增强了程序的可扩展性，当增加一个新的产品族时，不需要修改原代码，满足开闭原则。
 *
 * 其缺点是：当产品族中需要增加一个新的产品时，所有的工厂类都需要进行修改。增加了系统的抽象性和理解难度。
 **/
public class AbstractFactoryPattern {
    interface AbstactFactory {
        public Product newProduct();
        public Product2 newProduct2();
    }

    class ConcreteFactory1 implements AbstactFactory {
        public Product newProduct() {
            System.out.println("具体工厂 1 生成-->具体产品 11...");
            return new ConcreteProduct11();
        }
        public Product2 newProduct2() {
            System.out.println("具体工厂 1 生成-->具体产品 21...");
            return new ConcreteProduct21();
        }
    }
}
