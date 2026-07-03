package com.bistu.concurrent.methods;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.LockSupport;

//常见方法

/**
 * 与 Object 的 wait & notify 相比
 * wait，notify 和 notifyAll 必须配合 Object Monitor 一起使用，而 park，unpark 不必
 * park & unpark 是以线程为单位来【阻塞】和【唤醒】线程，而 notify 只能随机唤醒一个等待线程，notifyAll是唤醒所有等待线程，就不那么【精确】
 * park & unpark 可以先 unpark，而 wait & notify 不能先 notify
 */
public class demo9 {
    private static final Logger log = LoggerFactory.getLogger(demo9.class);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("start...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.debug("park...");
            LockSupport.park();
            log.debug("resume...");
        }, "t1");
        t1.start();

        Thread.sleep(1000);
        log.debug("unpark...");
        LockSupport.unpark(t1);
    }
}
