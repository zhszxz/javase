package com.bistu.concurrent.threadSafety.lock;

import com.bistu.concurrent.util.Sleeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

//ReentrantLock：可重入锁
//lockInterruptibly():尝试获得锁，如果失败进入阻塞队列，可以被interrupt()打断
//tryLock():尝试获得锁，不带参数获取失败直接返回，带参数获取失败等待一定时间
public class TestReentrantLock1 {
    private static final Logger log = LoggerFactory.getLogger(TestReentrantLock1.class);

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.debug("尝试获得锁");
            try {
                if (!lock.tryLock(2, TimeUnit.SECONDS)) {
                    log.debug("获取不到锁");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.debug("获取不到锁");
                return;
            }
            try {
                log.debug("获得到锁");
            } finally {
                lock.unlock();
            }
        }, "t1");


        lock.lock();
        log.debug("获得到锁");
        t1.start();
        Sleeper.sleep(1);
        log.debug("释放了锁");
        lock.unlock();
    }

}
