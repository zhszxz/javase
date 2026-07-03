package com.bistu.concurrent.methods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.LockSupport;

//常见方法
public class demo8 {

    private static final Logger log = LoggerFactory.getLogger(demo8.class);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
            log.debug("线程被打断......");
        });

        //setDaemon():设置为守护线程，其他线程结束后，无论守护线程有没有执行完，都会直接结束
        thread.setDaemon(true);
        thread.start();

        Thread.sleep(1000);
        log.debug("线程结束......");
    }

}
