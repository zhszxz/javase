package com.bistu.concurrent.createThread;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//创建线程方式一
public class demo1 {

    private static final Logger log = LoggerFactory.getLogger(demo1.class);

    public static void main(String[] args) {

       /* Thread thread = new Thread() {
            @Override
            public void run() {
                log.info("running......");
            }
        };*/

        //lambda表达式简化
        Thread thread = new Thread(() -> log.info("running......"));
        thread.start();

        log.error("running......");
    }
}
