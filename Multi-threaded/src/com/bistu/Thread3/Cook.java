package com.bistu.Thread3;

public class Cook extends Thread {
    /*
     * 1. 循环
     * 2. 同步代码块
     * 3. 判断共享数据是否到了末尾（到了末尾）
     * 4. 判断共享数据是否到了末尾（没有到末尾，执行核心逻辑）
     * */

    @Override
    public void run() {
        while (true) {
            synchronized (Desk.obj) {
                if (Desk.count == 0) {
                    break;
                }
                if (Desk.foodflag == 1) {
                    try {
                        Desk.obj.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("厨师正在做第" + (11-Desk.count) + "碗面");
                    Desk.foodflag++;
                    Desk.obj.notifyAll();
                }
            }

        }
    }
}
