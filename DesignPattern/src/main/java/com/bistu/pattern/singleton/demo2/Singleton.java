package com.bistu.pattern.singleton.demo2;

//单例模式:饿汉式，实现方式2静态代码块
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    static {
        instance = new Singleton();
    }

    public static Singleton getInstance() {
        return instance;
    }
}
