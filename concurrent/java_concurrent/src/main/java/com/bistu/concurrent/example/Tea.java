package com.bistu.concurrent.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tea {

    private static final Logger log = LoggerFactory.getLogger(Tea.class);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                log.debug("洗水壶");
                Thread.sleep(1000);
                log.debug("烧开水");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "老王");

        Thread t2 = new Thread(() -> {
            try {
                log.debug("洗茶壶");
                Thread.sleep(1000);
                log.debug("洗茶杯");
                Thread.sleep(2000);
                log.debug("拿茶叶");
                Thread.sleep(1000);
                t1.join();
                log.debug("茶泡好了");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "小王");

        t1.start();
        t2.start();
    }
}

