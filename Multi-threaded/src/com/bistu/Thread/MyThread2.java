package com.bistu.Thread;

public class MyThread2 implements Runnable{
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        for (int i = 0; i < 100; i++) {
            System.out.println(thread.getName()+"HelloWorld!");
        }
    }
}
