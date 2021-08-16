package com.max.learning.design_pattern.behavioral.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @program: learning
 * @description: 观察者模式
 * @author: Max.Tu
 * @create: 2021-08-17 00:02
 * Observer 接口是抽象观察者，它监视目标对象的变化，当目标对象发生变化时，观察者得到通知，
 * 并调用 void update(Observable o,Object arg) 方法，进行相应的工作。
 *
 * 观察者模式是一种对象行为型模式，其主要优点如下。
 * 降低了目标与观察者之间的耦合关系，两者之间是抽象耦合关系。符合依赖倒置原则。
 * 目标与观察者之间建立了一套触发机制。
 *
 * 它的主要缺点如下。
 * 目标与观察者之间的依赖关系并没有完全解除，而且有可能出现循环引用。
 * 当观察者对象很多时，通知的发布会花费很多时间，影响程序的效率。
 **/
public class ObserverPattern {
    public static void main(String[] args) {
        OilFutures oil = new OilFutures();
        Observer bull = new Bull(); //多方
        Observer bear = new Bear(); //空方
        oil.addObserver(bull);
        oil.addObserver(bear);
        oil.setPrice(10);
        oil.setPrice(-8);
    }
}

//具体目标类：原油期货
class OilFutures extends Observable {
    private float price;
    public float getPrice() {
        return this.price;
    }
    public void setPrice(float price) {
        super.setChanged();  //设置内部标志位，注明数据发生变化
        super.notifyObservers(price);    //通知观察者价格改变了
        this.price = price;
    }
}
//具体观察者类：多方
class Bull implements Observer {
    public void update(Observable o, Object arg) {
        Float price = ((Float) arg).floatValue();
        if (price > 0) {
            System.out.println("油价上涨" + price + "元，多方高兴了！");
        } else {
            System.out.println("油价下跌" + (-price) + "元，多方伤心了！");
        }
    }
}
//具体观察者类：空方
class Bear implements Observer {
    public void update(Observable o, Object arg) {
        Float price = ((Float) arg).floatValue();
        if (price > 0) {
            System.out.println("油价上涨" + price + "元，空方伤心了！");
        } else {
            System.out.println("油价下跌" + (-price) + "元，空方高兴了！");
        }
    }
}