package com.bistu.concurrent.threadSafety.syn;


import com.bistu.concurrent.util.Sleeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMultiLock {
    private static final Logger log = LoggerFactory.getLogger(TestMultiLock.class);

    public static void main(String[] args) {
        BigRoom bigRoom = new BigRoom();
        new Thread(() -> {
            bigRoom.study();
        }, "小南").start();
        new Thread(() -> {
            bigRoom.sleep();
        }, "小女").start();
    }
}

class BigRoom {
    private static final Logger log = LoggerFactory.getLogger(BigRoom.class);

    private final Object studyRoom = new Object();

    private final Object bedRoom = new Object();

    public void sleep() {
        synchronized (bedRoom) {
            log.debug("sleeping 2 小时");
            Sleeper.sleep(2);
        }
    }

    public void study() {
        synchronized (studyRoom) {
            log.debug("study 1 小时");
            Sleeper.sleep(1);
        }
    }

}
