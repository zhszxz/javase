package com.bistu.pattern.singleton.demo4;

//单例模式:懒汉式,使用双重检查锁解决线程安全问题同时保证性能
public class Singleton {

    //私有的本类对象
    private static volatile Singleton instance;

    //私有构造方法
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
