package com.bistu.MyPractice6;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread extends Thread{
    static ArrayList<Integer> list =new ArrayList<>();
    static int allMAX;
    static String ThreadName;

    private int max;
    private int count;

    private ArrayList<Integer> price=new ArrayList<>();

    static {
        Collections.addAll(list, 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);
        Collections.shuffle(list);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (MyThread.class) {
                if (list.isEmpty()) {
                    break;
                }
                int i = list.remove(0);
                count += i;
                if (i > max) {
                    max = i;
                }
                if (max > allMAX) {
                    allMAX = max;
                    ThreadName = getName();
                }
                price.add(i);
            }
        }
        System.out.println(Thread.currentThread().getName() + "抽出了" + price.toString() + "最大奖项为：" + max + "总计：" + count);
        if (getName().equals(ThreadName)) {
            System.out.println("此次抽奖中，" + ThreadName + "抽出了最大奖金，为" + allMAX);
        }
    }
}
