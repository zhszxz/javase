package com.bistu.pattern.singleton.demo6;

public class Client {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.instance;
        Singleton instance2 = Singleton.instance;
        System.out.println(instance1 == instance2);
    }
}
