package com.bistu.concurrent.createThread;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//创建线程方式二
public class demo2 {

    private static final Logger log = LoggerFactory.getLogger(demo2.class);

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log.info("running......");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        log.error("running......");
    }
}
