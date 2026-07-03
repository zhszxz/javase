package com.bistu.pattern.singleton.demo6;

//单例模式:饿汉式，枚举实现，线程安全且是唯一不会被破坏的单例实现方式
public enum Singleton {
    instance;
}
