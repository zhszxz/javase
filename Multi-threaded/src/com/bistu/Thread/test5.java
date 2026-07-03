package com.bistu.Thread;

public class test5 {
    public static void main(String[] args) {
        MyThread5 mt1 = new MyThread5();
        MyThread5 mt2 = new MyThread5();

        Thread t1 = new Thread(mt1, "飞机");
        Thread t2 = new Thread(mt2, "坦克");

        t1.setPriority(1);
        t2.setPriority(10);

        t1.start();
        t2.start();
    }
}
