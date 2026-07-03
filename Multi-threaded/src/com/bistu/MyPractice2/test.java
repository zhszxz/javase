package com.bistu.MyPractice2;

public class test {
    public static void main(String[] args) {
        MyThread mt1=new MyThread();
        MyThread mt2=new MyThread();

        mt1.setName("路人甲");
        mt2.setName("路人乙");

        mt1.start();
        mt2.start();
    }
}
