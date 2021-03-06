package com.max.design.create.singleton;

/**
 * 懒汉式单例模式
 * @author max
 * @date 2021/7/8 16:32
 * 单例模式有 3 个特点：
 * 单例类只有一个实例对象；
 * 该单例对象必须由单例类自行创建；
 * 单例类对外提供一个访问该单例的全局访问点。
 *
 * 单例模式的优点：
 * 单例模式可以保证内存里只有一个实例，减少了内存的开销。
 * 可以避免对资源的多重占用。
 * 单例模式设置全局访问点，可以优化和共享资源的访问。
 *
 * 单例模式的缺点：
 * 单例模式一般没有接口，扩展困难。如果要扩展，则除了修改原来的代码，没有第二种途径，违背开闭原则。
 * 在并发测试中，单例模式不利于代码调试。在调试过程中，如果单例中的代码没有执行完，也不能模拟生成一个新的对象。
 * 单例模式的功能代码通常写在一个类中，如果功能设计不合理，则很容易违背单一职责原则。
 */
public class LazySingleton {
    //保证 instance 在所有线程同步
    private static volatile LazySingleton instance = null;

    private LazySingleton() {
        //private 避免类在外部实例化
    }

    private static synchronized LazySingleton getInstance() {
        if(instance == null) {
            instance = new LazySingleton();
        } else {
            System.out.println("懒汉单例已经创建");
        }
        return instance;
    }
}
