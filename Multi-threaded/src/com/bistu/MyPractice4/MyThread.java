package com.bistu.MyPractice4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MyThread extends Thread {
    static ArrayList<Integer> list = new ArrayList<>();
    static int money = 100;

    static {
        Random r = new Random();

        for (int i = 0; i < 2; i++) {
            int red = r.nextInt(money + 1);
            list.add(red);
            money -= red;
        }
        list.add(money);
        list.add(0);
        list.add(0);

        Collections.shuffle(list);
    }

    @Override
    public void run() {

        synchronized (MyThread.class) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (list.size() == 0) {
                return;
            }
            int red = list.get(0);
            if (red != 0) {
                System.out.println(getName() + "抢到了" + red + "元");
            } else {
                System.out.println(getName() + "没抢到");
            }
            list.remove(0);
        }
    }
}


