package com.bistu.concurrent.threadSafety.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//活锁：多个线程互相改变结束条件导致虽然线程一直执行但永远结束不了
public class TestLiveLock {
    private static final Logger log = LoggerFactory.getLogger(TestLiveLock.class);

    static volatile int count = 10;
    static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            // 期望减到 0 退出循环
            while (count > 0) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count--;
                log.debug("count: {}", count);
            }
        }, "t1").start();
        new Thread(() -> {
            // 期望超过 20 退出循环
            while (count < 20) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
                log.debug("count: {}", count);
            }
        }, "t2").start();
    }
}
