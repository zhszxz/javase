package com.bistu.concurrent.aqs;

import com.bistu.concurrent.util.Sleeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


//CountDownLatch:用来进行线程同步协作，等待所有线程完成倒计时。
//其中构造参数用来初始化等待计数值，await() 用来等待计数归零，countDown() 用来让计数减一
public class TestCountDownLatch {
    private static final Logger log = LoggerFactory.getLogger(TestCountDownLatch.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        test3();
    }

    private static void test1() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        new Thread(() -> {
            log.debug("begin...");
            Sleeper.sleep(1);
            latch.countDown();
            log.debug("end...{}", latch.getCount());
        }).start();

        new Thread(() -> {
            log.debug("begin...");
            Sleeper.sleep(2);
            latch.countDown();
            log.debug("end...{}", latch.getCount());
        }).start();

        new Thread(() -> {
            log.debug("begin...");
            Sleeper.sleep(1);
            latch.countDown();
            log.debug("end...{}", latch.getCount());
        }).start();

        log.debug("waiting...");
        latch.await();
        log.debug("wait end...");
    }

    private static void test2() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService pool = Executors.newFixedThreadPool(4);

        pool.submit(new Thread(() -> {
            log.debug("begin...");
            Sleeper.sleep(1);
            latch.countDown();
            log.debug("end...{}", latch.getCount());
        }));

        pool.submit(new Thread(() -> {
            log.debug("begin...");
            Sleeper.sleep(2);
            latch.countDown();
            log.debug("end...{}", latch.getCount());
        }));

        pool.submit(new Thread(() -> {
            log.debug("begin...");
            Sleeper.sleep(3);
            latch.countDown();
            log.debug("end...{}", latch.getCount());
        }));

        pool.submit(new Thread(() -> {
            log.debug("waitting...");
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.debug("wait end...{}", latch.getCount());
        }));

    }

    private static void test3() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(10);
        String[] all = new String[10];
        Random r = new Random();
        for (int j = 0; j < 10; j++) {
            int x = j;
            service.submit(() -> {
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(r.nextInt(100));
                    } catch (InterruptedException e) {
                    }
                    all[x] = Thread.currentThread().getName() + "(" + (i + "%") + ")";
                    System.out.print("\r" + Arrays.toString(all));
                }
                latch.countDown();
            });
        }
        latch.await();
        System.out.println("\n游戏开始...");
        service.shutdown();
    }

}
