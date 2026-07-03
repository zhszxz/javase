package com.bistu.concurrent.threadSafety.syn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCorrectPostureStep1 {
    private static final Logger log = LoggerFactory.getLogger(TestCorrectPostureStep1.class);

    static final Object room = new Object();
    static boolean hasCigarette = false; // 有没有烟
    static boolean hasTakeout = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (room) {
                log.debug("有烟没？[{}]", hasCigarette);
                if (!hasCigarette) {
                    log.debug("没烟，先歇会！");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                log.debug("有烟没？[{}]", hasCigarette);
                if (hasCigarette) {
                    log.debug("可以开始干活了");
                }
            }
        }, "小南").start();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                synchronized (room) {
                    log.debug("可以开始干活了");
                }
            }, "其它人").start();
        }

        Thread.sleep(1000);
        new Thread(() -> {
            //这里能不能加 synchronized (room)？
            //synchronized (room) {
                hasCigarette = true;
                log.debug("烟到了噢！");
            //}
        }, "送烟的").start();
    }

}
