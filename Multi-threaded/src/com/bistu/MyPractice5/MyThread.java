package com.bistu.MyPractice5;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread implements Runnable {
    ArrayList<Integer> list =new ArrayList<>();

    MyThread() {
        Collections.addAll(list, 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);
        Collections.shuffle(list);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (MyThread.class) {
                if (list.size() == 0) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "抽出了一个" + list.get(0) + "元大奖");
                list.remove(0);
            }
        }
    }
}
