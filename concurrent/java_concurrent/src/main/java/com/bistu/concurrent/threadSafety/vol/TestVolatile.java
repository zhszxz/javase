package com.bistu.concurrent.threadSafety.vol;

import com.bistu.concurrent.util.Sleeper;

public class TestVolatile {
    // 易变
    volatile static boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                if (!run) {
                    break;
                }
            }
        });
        t.start();

        Sleeper.sleep(1);
        run = false; // 线程t不会如预想的停下来
    }
}
