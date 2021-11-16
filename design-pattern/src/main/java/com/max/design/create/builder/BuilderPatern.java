package com.max.design.create.builder;

import lombok.Data;

/**
 * @author max
 * @description: 建造者模式
 * @date 2021/8/12 19:19
 * 建造者模式注重零部件的组装过程，而工厂方法模式更注重零部件的创建过程，但两者可以结合使用。
 *
 * 建造者（Builder）模式的主要角色如下。
 * 产品角色（Product）：它是包含多个组成部件的复杂对象，由具体建造者来创建其各个零部件。
 * 抽象建造者（Builder）：它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法 getResult()。
 * 具体建造者(Concrete Builder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。
 * 指挥者（Director）：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息。
 */
public class BuilderPatern {

    public class Client {
        Director director = new Director(new Builder());
        Product product = director.construct();
    }


    @Data
    public class Product {
        private String partA;
        private String partB;
        private String partC;
    }

    public abstract class AbstractBuilder {
        protected  Product product;

        public abstract void builPartA();
        public abstract void builPartB();
        public abstract void builPartC();

        public Product getProduct() {
            return this.product;
        }
    }

    public class Builder extends AbstractBuilder{

        @Override
        public void builPartA() {
            product.setPartA("builder part A");
        }

        @Override
        public void builPartB() {
            product.setPartB("builder part B");
        }

        @Override
        public void builPartC() {
            product.setPartC("builder part C");
        }
    }

    public class Director {
        private AbstractBuilder builder;

        public Director(AbstractBuilder builder) {
            this.builder = builder;
        }

        public Product construct() {
            builder.builPartA();
            builder.builPartB();
            builder.builPartC();

            return builder.getProduct();
        }
    }
}
