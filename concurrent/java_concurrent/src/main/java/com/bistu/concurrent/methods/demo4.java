package com.bistu.concurrent.methods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//常见方法
public class demo4 {
    private static final Logger log = LoggerFactory.getLogger(demo4.class);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            int count = 0;
            while (true) {
                System.out.println("Thread 1 : " + count++);
                //yield()：提示线程调度器让出CPU,不一定会导致当前线程立即停止运行
                //Thread.yield();
            }
        });

        Thread thread2 = new Thread(() -> {
            int count = 0;
            while (true) {
                System.out.println("    Thread 2 : " + count++);
            }
        });

        //setPriority：设置线程优先级数字越大优先级越高
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();
    }
}
