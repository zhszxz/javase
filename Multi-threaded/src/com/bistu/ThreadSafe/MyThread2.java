package com.bistu.ThreadSafe;

public class MyThread2 implements Runnable {
    int ticket = 0;

    @Override
    public void run() {
        while (true) {
            if (sellticket()) break;
        }
    }

    private synchronized boolean sellticket() {
        if (ticket == 100) {
            return true;
        } else {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ticket++;
            System.out.println(Thread.currentThread().getName() + "卖出了第" + ticket + "张票");
        }
        return false;
    }
}
