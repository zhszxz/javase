package com.bistu.concurrent.methods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//常见方法
public class demo3 {
    private static final Logger log = LoggerFactory.getLogger(demo3.class);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread("t1") {
            @Override
            public void run() {
                log.debug("开始睡眠。。。");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.debug("睡眠被打断了。。。");
                    e.printStackTrace();
                }
            }
        };

        thread.start();
        Thread.sleep(1000);
        //中断线程，如果线程处于阻塞态（Object.wait(),Thread.sleep(),Thread.join()），会抛出InterruptedException
        thread.interrupt();

    }
}
