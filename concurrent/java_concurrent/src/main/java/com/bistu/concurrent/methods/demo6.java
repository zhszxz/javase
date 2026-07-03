package com.bistu.concurrent.methods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//常见方法
public class demo6 {
    private static final Logger log = LoggerFactory.getLogger(demo6.class);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                log.debug("sleepping...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                log.debug("thread线程 打断标志：{}", Thread.currentThread().isInterrupted());
            }
        });

       /* Thread thread = new Thread(() -> {
            while (true) {
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted) {
                    log.info("线程被打断了。。。。");
                    break;
                }
            }
        });*/

        thread.start();

        Thread.sleep(1000);
        //打断其他线程
        //如果是阻塞线程，设置打断标志为true并抛出异常，然后重置打断标志为false，最后回到可执行状态
        //如果是正常线程，仅设置打断标志，由该线程自己决定继续运行或停止
        //log.debug("wake up...");
        thread.interrupt();
        log.debug("main线程 打断标志：{}", thread.isInterrupted());
    }
}
