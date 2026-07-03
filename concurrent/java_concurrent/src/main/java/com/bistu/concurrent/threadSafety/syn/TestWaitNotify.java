package com.bistu.concurrent.threadSafety.syn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestWaitNotify {
    private static final Logger log = LoggerFactory.getLogger(TestWaitNotify.class);

    final static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (obj) {
                log.debug("执行....");
                try {
                    //wait(): 线程获取到obj锁之后，主动进入Monitor的waitSet，在obj上一直等待下去并释放锁
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("其它代码....");
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (obj) {
                log.debug("执行....");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("其它代码....");
            }
        }, "t2").start();

        // 主线程两秒后执行
        Thread.sleep(1000);
        log.debug("唤醒 obj 上其它线程");
        synchronized (obj) {
            //线程获取到obj锁之后，唤醒waitSet中在obj对象上等待的线程
            //obj.notify(); // 唤醒obj上一个线程
            obj.notifyAll(); // 唤醒obj上所有等待线程
        }
    }
}
