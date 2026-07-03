package com.bistu.ThreadSafe;

public class test1 {
    public static void main(String[] args) {
        /*
           需求：
                某电影院目前正在上映国产大片，共有100张票，而它有3个窗口卖票，请设计一个程序模拟该电影院卖票
       */

        MyThread1 mt1=new MyThread1();
        MyThread1 mt3=new MyThread1();
        MyThread1 mt2=new MyThread1();

        mt1.setName("窗口1");
        mt2.setName("窗口2");
        mt3.setName("窗口3");

        mt1.start();
        mt2.start();
        mt3.start();
    }
}
