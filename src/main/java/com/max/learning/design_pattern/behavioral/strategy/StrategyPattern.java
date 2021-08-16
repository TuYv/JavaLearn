package com.max.learning.design_pattern.behavioral.strategy;

/**
 * @program: learning
 * @description: 策略模式
 * @author: Max.Tu
 * @create: 2021-08-16 22:49
 **/
public class StrategyPattern {

    //抽象策略类
    interface Strategy {
        public void strategyMethod();    //策略方法
    }
    //具体策略类A
    class ConcreteStrategyA implements Strategy {
        public void strategyMethod() {
            System.out.println("具体策略A的策略方法被访问！");
        }
    }
    //具体策略类B
    class ConcreteStrategyB implements Strategy {
        public void strategyMethod() {
            System.out.println("具体策略B的策略方法被访问！");
        }
    }
    //环境类
    class Context {
        private Strategy strategy;
        public Strategy getStrategy() {
            return strategy;
        }
        public void setStrategy(Strategy strategy) {
            this.strategy = strategy;
        }
        public void strategyMethod() {
            strategy.strategyMethod();
        }
    }
}
