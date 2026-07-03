package com.bistu.Thread2;

public class test3 {
    public static void main(String[] args) throws InterruptedException {
          /*
            public final void join()  插入线程/插队线程
       */


        MyThread3 mt1=new MyThread3();
        mt1.setName("土豆");
        mt1.start();

        mt1.join();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"@"+i);
        }
    }
}
