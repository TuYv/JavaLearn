package com.max.design.create.realizatype;

/**
 * 原型模式
 * @author max
 * @date 2021/7/8 17:23
 *
 * 原型（Prototype）模式的定义如下：用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。在这里，原型实例指定了要创建的对象的种类。用这种方式创建对象非常高效，
 * 根本无须知道对象创建的细节。例如，Windows 操作系统的安装通常较耗时，如果复制就快了很多。在生活中复制的例子非常多，这里不一一列举了。
 * 原型模式的优点：
 * Java 自带的原型模式基于内存二进制流的复制，在性能上比直接 new 一个对象更加优良。
 * 可以使用深克隆方式保存对象的状态，使用原型模式将对象复制一份，并将其状态保存起来，简化了创建对象的过程，以便在需要的时候使用（例如恢复到历史某一状态），可辅助实现撤销操作。
 * 原型模式的缺点：
 * 需要为每一个类都配置一个 clone 方法
 * clone 方法位于类的内部，当对已有类进行改造的时候，需要修改代码，违背了开闭原则。
 * 当实现深克隆时，需要编写较为复杂的代码，而且当对象之间存在多重嵌套引用时，为了实现深克隆，每一层对象对应的类都必须支持深克隆，实现起来会比较麻烦。因此，深克隆、浅克隆需要运用得当。
 *
 * 原型模式的克隆分为浅克隆和深克隆。
 * 浅克隆：创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址。
 * 深克隆：创建一个新对象，属性中引用的其他对象也会被克隆，不再指向原有对象地址。
 *
 * Java 中的 Object 类提供了浅克隆的 clone() 方法，具体原型类只要实现 Cloneable 接口就可实现对象的浅克隆，
 */
public class RealizaType implements Cloneable{
    RealizaType() {
        System.out.println("具体原型类创建成功！");
    }
    public Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型类拷贝成功!");
        return (RealizaType) super.clone();
    }


    //原型模式的测试类
    //原型模式 对于一个对象 实现一个克隆自己的方法，之后需要一个新的实例直接调用这个克隆方法就可以了
        public static void main(String[] args) throws CloneNotSupportedException {
            RealizaType obj1 = new RealizaType();
            RealizaType obj2 = (RealizaType) obj1.clone();
            System.out.println("obj1==obj2?" + (obj1 == obj2));
        }

}
