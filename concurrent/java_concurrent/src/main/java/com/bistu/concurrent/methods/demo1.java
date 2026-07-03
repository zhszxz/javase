package com.bistu.concurrent.methods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//常见方法
public class demo1 {
    private static final Logger log = LoggerFactory.getLogger(demo1.class);

    public static void main(String[] args) {

        Thread thread = new Thread("t1") {
            //run()：线程实际执行的方法
            @Override
            public void run() {
                log.info("running......");
            }
        };
        //getState():获取线程状态
        System.out.println(thread.getState());
        //start():使线程从NEW状态变为RUNNABLE状态，并不是立即开始执行
        thread.start();
        System.out.println(thread.getState());
    }
}
