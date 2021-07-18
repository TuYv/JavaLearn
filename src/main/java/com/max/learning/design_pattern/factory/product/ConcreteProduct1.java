package com.max.learning.design_pattern.factory.product;

public class ConcreteProduct1 implements Product {
        @Override
        public void show() {
            System.out.println("具体产品1显示");
        }
}