package com.max.design.structure.composite;

import java.util.ArrayList;

/**
 * @program: learning
 * @description: 组合模式
 * @author: Max.Tu
 * @create: 2021-08-15 00:08
 * 组合模式的主要优点有：
 * 组合模式使得客户端代码可以一致地处理单个对象和组合对象，无须关心自己处理的是单个对象，还是组合对象，这简化了客户端代码；
 * 更容易在组合体内加入新的对象，客户端不会因为加入了新的对象而更改源代码，满足“开闭原则”；
 *
 * 其主要缺点是：
 * 设计较复杂，客户端需要花更多时间理清类之间的层次关系；
 * 不容易限制容器中的构件；
 * 不容易用继承的方法来增加构件的新功能；
 **/
public class CompositePattern {
    //抽象构件
    interface Component {
        public void add(Component c);
        public void remove(Component c);
        public Component getChild(int i);
        public void operation();
    }
    //树叶构件
    class Leaf implements Component {
        private String name;
        public Leaf(String name) {
            this.name = name;
        }
        public void add(Component c) {
        }
        public void remove(Component c) {
        }
        public Component getChild(int i) {
            return null;
        }
        public void operation() {
            System.out.println("树叶" + name + "：被访问！");
        }
    }
    //树枝构件
    class Composite implements Component {
        private ArrayList<Component> children = new ArrayList<Component>();
        public void add(Component c) {
            children.add(c);
        }
        public void remove(Component c) {
            children.remove(c);
        }
        public Component getChild(int i) {
            return children.get(i);
        }
        public void operation() {
            for (Object obj : children) {
                ((Component) obj).operation();
            }
        }
    }
}
