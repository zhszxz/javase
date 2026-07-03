package com.bistu.concurrent.methods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.concurrent.locks.LockSupport;

//常见方法
public class demo7 {

    private static final Logger log = LoggerFactory.getLogger(demo7.class);

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    /*public static void test() throws InterruptedException {
        Thread thread = new Thread(() -> {
            log.debug("park......");
            //若打断标志为false，使当前线程进入阻塞状态
            LockSupport.park();
            log.debug("unpark......");
            log.debug("打断状态：{}", Thread.currentThread().isInterrupted());
            //再次调用不会生效
            LockSupport.park();
            log.debug("unpark......");
        });

        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }*/

    public static void test() throws InterruptedException {
        Thread thread = new Thread(() -> {
            log.debug("park......");
            //若打断标志为false，使当前线程进入阻塞状态
            LockSupport.park();
            log.debug("unpark......");
            //Thread.interrupted():获取线程打断状态，同时设置打断状态为false
            log.debug("打断状态：{}", Thread.interrupted());
            //再次调用可以生效
            LockSupport.park();
            log.debug("unpark......");
        });

        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
