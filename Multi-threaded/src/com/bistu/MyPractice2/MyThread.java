package com.bistu.MyPractice2;

public class MyThread extends Thread{
    static int gift=100;

    @Override
    public void run() {
        while (true){
            synchronized (MyThread.class){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (gift<10){
                    break;
                }
                gift--;
                System.out.println(getName()+"送出了一份礼物，还剩"+gift+"份");
            }
        }
    }
}
