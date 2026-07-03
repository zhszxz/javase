package com.bistu.pattern.singleton.demo7;

import java.io.Serializable;

//破坏单例模式：序列化
//解决方案：定义readResolve方法，反序列化流底层会判断是否定义了这个方法，如果是，则直接返回该方法返回值，否则new对象返回
public class Singleton implements Serializable {

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

    public Object readResolve() {
        return SingletonHolder.INSTANCE;
    }
}
