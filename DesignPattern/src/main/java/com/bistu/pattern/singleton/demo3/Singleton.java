package com.bistu.pattern.singleton.demo3;

//单例模式:懒汉式,使用synchronized解决线程安全问题，但是性能有损失
public class Singleton {

    //私有的本类对象
    private static Singleton instance;

    //私有构造方法
    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        return instance == null ? instance = new Singleton() : instance;
    }
}
