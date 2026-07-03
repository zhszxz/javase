package com.bistu.Thread4;

import com.bistu.Thread3.Desk;

import java.util.concurrent.ArrayBlockingQueue;

public class Cook extends Thread {
    ArrayBlockingQueue<String> queue;

    public Cook(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            if (queue.size() != 1) {
                try {
                    queue.put("面条");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("厨师放了一碗面条");

            }

        }
    }

}
