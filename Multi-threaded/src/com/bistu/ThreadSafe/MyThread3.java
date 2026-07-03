package com.bistu.ThreadSafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread3 extends Thread {
    static int ticket = 0;
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {
            lock.lock();
            try {
                Thread.sleep(10);
                if (ticket == 100) {
                    break;
                } else {
                    ticket++;
                    System.out.println(getName() + "卖出了第" + ticket + "张票");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }
}
