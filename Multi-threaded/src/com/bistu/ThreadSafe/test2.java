package com.bistu.ThreadSafe;

public class test2 {
    public static void main(String[] args) {
         /*
           需求：
                某电影院目前正在上映国产大片，共有100张票，而它有3个窗口卖票，请设计一个程序模拟该电影院卖票
                使用同步方法实现
     */

        MyThread2 mt=new MyThread2();

        Thread t1=new Thread(mt,"窗口1");
        Thread t2=new Thread(mt,"窗口2");
        Thread t3=new Thread(mt,"窗口3");

        t1.start();
        t2.start();
        t3.start();
    }



}
