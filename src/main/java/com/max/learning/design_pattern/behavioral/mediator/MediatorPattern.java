package com.max.learning.design_pattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介者模式
 * @author max
 * @date 2021/8/17 18:15
 */
public class MediatorPattern {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Colleague colleague1 = new ConcreteColleague1();
        Colleague colleague2 = new ConcreteColleague2();
        mediator.register(colleague1);
        mediator.register(colleague2);
        colleague1.send();
        colleague2.send();
    }

}
//抽象中介者
abstract class Mediator {
    public abstract void register(Colleague colleague);
    public abstract void relay(Colleague colleague);
}
//具体中介者
class ConcreteMediator extends Mediator {
    private List<Colleague> colleagues  = new ArrayList<Colleague>();;

    @Override
    public void register(Colleague colleague) {
        if(!colleagues.contains(colleague)) {
            colleagues.add(colleague);
            colleague.setMediator(this);
        }
    }

    @Override
    public void relay(Colleague colleague) {
        colleagues.forEach(x -> {
            if(!x.equals(colleague)) {
                x.receive();
            }
        });
    }
}
//抽象同事
abstract class Colleague {
    protected Mediator mediator;
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    public abstract void receive();
    public abstract void send();
}
//具体同事1
class ConcreteColleague1 extends Colleague {

    @Override
    public void receive() {
        System.out.println("同事1接收到消息");
    }

    @Override
    public void send() {
        System.out.println("同事1发送消息");
        mediator.relay(this);
    }
}
//具体同事2
class ConcreteColleague2 extends Colleague {

    @Override
    public void receive() {
        System.out.println("同事2接收到消息");
    }

    @Override
    public void send() {
        System.out.println("同事2发送消息");
        mediator.relay(this);
    }
}
