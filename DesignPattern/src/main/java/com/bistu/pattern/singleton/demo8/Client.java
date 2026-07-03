package com.bistu.pattern.singleton.demo8;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Client {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Singleton> clazz = Singleton.class;
        Constructor<Singleton> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton instance1 = constructor.newInstance();
        Singleton instance2 = constructor.newInstance();
        System.out.println(instance1 == instance2);
    }
}
