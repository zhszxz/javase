package com.bistu.pattern.singleton.demo1;

//单例模式:饿汉式，实现方式1
public class Singleton {

    //私有的本类对象
    private static Singleton instance = new Singleton();

    //私有构造方法
    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}
