package com.bistu.concurrent.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

//通过wait notify控制线程执行顺序
/*public class SequentialExecution {
    private static final Logger log = LoggerFactory.getLogger(SequentialExecution.class);

    static final Object lock = new Object();
    // 表示 t2 是否运行过
    static boolean t2runned = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                while (!t2runned) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("1");
            }
        }, "t1");


        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                log.debug("2");
                t2runned = true;
                lock.notify();
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}*/

//通过ReentrantLock控制线程执行顺序
public class SequentialExecution {
    private static final Logger log = LoggerFactory.getLogger(SequentialExecution.class);

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    // 表示 t2 是否运行过
    static volatile boolean t2runned = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                while (!t2runned) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); // 处理线程中断
                    }
                }
                log.debug("1");
            } finally {
                lock.unlock();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                log.debug("2");
                t2runned = true;
                condition.signal(); // 唤醒 t1
            } finally {
                lock.unlock();
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}


//通过LockSupport控制线程执行顺序
/*public class SequentialExecution {
    private static final Logger log = LoggerFactory.getLogger(SequentialExecution.class);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            LockSupport.park();
            log.debug("1");
        }, "t1");


        Thread t2 = new Thread(() -> {
            log.debug("2");
            LockSupport.unpark(t1);
        }, "t2");

        t1.start();
        t2.start();
    }
}*/


