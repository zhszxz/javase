package com.bistu.Thread4;

import java.util.concurrent.ArrayBlockingQueue;

public class test {
        public static void main(String[] args) {

            ArrayBlockingQueue<String> queue=new ArrayBlockingQueue<>(1);

            Cook c=new Cook(queue);
            Foodie f=new Foodie(queue);

            c.setName("厨师");
            f.setName("吃货");

            c.start();
            f.start();
        }
}
