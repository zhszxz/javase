package com.bistu.concurrent.methods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//常见方法
public class demo5 {
    private static final Logger log = LoggerFactory.getLogger(demo5.class);

    static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num = 10;
        });
        thread.start();

        //join():使当前线程等待thread线程运行结束后再继续执行
        //thread.join();
        thread.join(500);
        System.out.println(num);
    }
}
