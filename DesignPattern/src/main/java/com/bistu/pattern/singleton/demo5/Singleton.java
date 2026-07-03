package com.bistu.pattern.singleton.demo5;

//单例模式:懒汉式,静态内部类方式
//静态内部类只有在被访问时才会初始化，这种方式既能在不加锁的情况下保证线程安全，又没有任何性能损失
public class Singleton {

    //私有构造方法
    private Singleton() {
    }

    private static class SingletonHolder {
        //私有的外部类对象
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
