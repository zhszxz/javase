package com.bistu.concurrent.threadSafety.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.StampedLock;

//StampedLock:特点是在使用读锁、写锁时都必须配合【戳】使用
//乐观读，StampedLock 支持 tryOptimisticRead() 方法（乐观读），读取完毕后需要做一次 戳校验 如果校验通过，
//表示这期间确实没有写操作，数据可以安全使用，如果校验没通过，需要重新获取读锁，保证数据安全。
//StampedLock 不支持条件变量,不支持重入
public class TestStampedLock {
    private static final Logger log = LoggerFactory.getLogger(TestStampedLock.class);

    public static void main(String[] args) throws InterruptedException {
        DataContainerStamped dataContainer = new DataContainerStamped(1);
        new Thread(() -> {
            dataContainer.read(1000);
        }, "t1").start();
        Thread.sleep(500);
        new Thread(() -> {
            dataContainer.read(0);
        }, "t2").start();
    }
}

class DataContainerStamped {
    private static final Logger log = LoggerFactory.getLogger(DataContainerStamped.class);
    private int data;
    private final StampedLock lock = new StampedLock();

    public DataContainerStamped(int data) {
        this.data = data;
    }

    public int read(int readTime) {
        long stamp = lock.tryOptimisticRead();
        log.debug("optimistic read locking...{}", stamp);
        try {
            Thread.sleep(readTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (lock.validate(stamp)) {
            log.debug("read finish...{}, data:{}", stamp, data);
            return data;
        }
        // 锁升级 - 读锁
        log.debug("updating to read lock... {}", stamp);
        try {
            stamp = lock.readLock();
            log.debug("read lock {}", stamp);
            Thread.sleep(readTime);
            log.debug("read finish...{}, data:{}", stamp, data);
            return data;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            log.debug("read unlock {}", stamp);
            lock.unlockRead(stamp);
        }
    }

    public void write(int newData) {
        long stamp = lock.writeLock();
        log.debug("write lock {}", stamp);
        try {
            Thread.sleep(1000);
            this.data = newData;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            log.debug("write unlock {}", stamp);
            lock.unlockWrite(stamp);
        }
    }
}
