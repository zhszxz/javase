package com.bistu.concurrent.threadSafety;

import java.util.ArrayList;

public class TestThreadSafe {

    static final int THREAD_NUMBER = 2;
    static final int LOOP_NUMBER = 200;

    public static void main(String[] args) {
        //ThreadUnsafe test = new ThreadUnsafe();
        //ThreadSafe test = new ThreadSafe();
        ThreadSafeSubClass test = new ThreadSafeSubClass();
        for (int i = 0; i < THREAD_NUMBER; i++) {
            new Thread(() -> {
                test.method1(LOOP_NUMBER);
            }, "Thread" + (i + 1)).start();
        }
    }
}

/**
 * 成员变量和静态变量是否线程安全？
 * 如果它们没有共享，则线程安全
 * 如果它们被共享了，根据它们的状态是否能够改变，又分两种情况
 * 如果只有读操作，则线程安全
 * 如果有读写操作，则这段代码是临界区，需要考虑线程安全
 */
class ThreadUnsafe {
    ArrayList<String> list = new ArrayList<>();

    public void method1(int loopNumber) {
        for (int i = 0; i < loopNumber; i++) {
            method2();
            method3();
        }
    }

    private void method2() {
        list.add("1");
    }

    private void method3() {
        list.remove(0);
    }
}

/**
 * 局部变量是线程安全的
 * 但局部变量引用的对象则未必
 * 如果该对象没有逃离方法的作用访问，它是线程安全的
 * 如果该对象逃离方法的作用范围，需要考虑线程安全
 */
class ThreadSafe {
    public final void method1(int loopNumber) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < loopNumber; i++) {
            method2(list);
            method3(list);
        }
    }

    public void method2(ArrayList<String> list) {
        list.add("1");
    }

    public void method3(ArrayList<String> list) {
        list.remove(0);
    }
}

/**
 * 局部变量是线程安全的
 * 但局部变量引用的对象则未必
 * 如果该对象没有逃离方法的作用访问，它是线程安全的
 * 如果该对象逃离方法的作用范围，需要考虑线程安全
 */
class ThreadSafeSubClass extends ThreadSafe {
    @Override
    public void method3(ArrayList<String> list) {
        new Thread(() -> {
            list.remove(0);
        }).start();
    }
}