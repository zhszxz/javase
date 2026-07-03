package com.bistu.concurrent.threadSafety.syn;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * sleep和wait的区别
 * sleep是Thread类的方法，wait是Object类的方法
 * wait需要与synchronized配合使用，sleep不需要
 * sleep不会释放锁，wait会释放锁
 */
public class TestSleepWait {

    private static final Logger log = LoggerFactory.getLogger(Synchronized.class);

    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (lock) {
                log.debug("获得锁");
                try {
                   Thread.sleep(20000);
                   // lock.wait(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        Thread.sleep(1000);
        synchronized (lock) {
            log.debug("获得锁");
        }
    }
}
