package com.bistu.concurrent.methods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//常见方法
public class demo2 {
    private static final Logger log = LoggerFactory.getLogger(demo2.class);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread("t1") {
            @Override
            public void run() {
                log.info("线程状态：{}", this.getState());
                try {
                    //sleep():使线程从RUNNABLE状态转换为TIMED_WAITING状态
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        thread.start();
        Thread.sleep(1000);

        log.info("线程状态：{}", thread.getState());
    }
}
