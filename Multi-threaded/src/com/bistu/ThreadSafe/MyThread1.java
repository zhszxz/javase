package com.bistu.ThreadSafe;

public class MyThread1 extends Thread {
    static int ticket = 0;
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (MyThread1.class){
                if (ticket < 100) {
                    ticket++;
                    System.out.println(getName() + "卖出了第" + ticket + "张票");
                } else {
                    break;
                }
            }
        }
    }
}
