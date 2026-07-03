package com.bistu.Thread;

public class MyThread4 extends Thread{

    public MyThread4() {
    }

    public MyThread4(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            System.out.println(getName() + "@" + i);
            //出让cpu，使打印结果尽可能均匀
            Thread.yield();
        }
    }
}
