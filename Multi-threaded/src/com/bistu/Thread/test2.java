package com.bistu.Thread;

public class test2 {
    public static void main(String[] args) {
        /*
         * 多线程的第二种启动方式：
         *   1.自己定义一个类实现Runnable接口
         *   2.重写里面的run方法
         *   3.创建自己的类的对象
         *   4.创建一个Thread类的对象，并开启线程
         * */

        MyThread2 mt=new MyThread2();

        Thread t1=new Thread(mt);
        Thread t2=new Thread(mt);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
