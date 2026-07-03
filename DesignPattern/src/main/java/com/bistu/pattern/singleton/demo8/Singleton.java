package com.bistu.pattern.singleton.demo8;

//破坏单例模式：反射
//解决方案：判断是否是第一次调用构造方法
public class Singleton {
    private static boolean flag = true;

    //私有构造方法
    private Singleton() {
        synchronized (Singleton.class) {
            if (!flag) {
                throw new RuntimeException("不能创建多个Singleton对象");
            }
            flag = false;
        }
    }

    private static class SingletonHolder {
        //私有的外部类对象
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
