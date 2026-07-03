package com.bistu.concurrent.threadPool.executors;

import com.bistu.concurrent.util.Sleeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestExecutors {
    private static final Logger log = LoggerFactory.getLogger(TestExecutors.class);

    public static void main(String[] args) throws InterruptedException {
        test5();
    }

    //固定数量的线程池
    private static void test1() {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.execute(() -> {
            log.debug("1");
        });

        pool.execute(() -> {
            log.debug("2");
        });

        pool.execute(() -> {
            log.debug("3");
        });
    }

    //单线程的线程池
    public static void test2() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.execute(() -> {
            log.debug("1");
            int i = 1 / 0;
        });

        pool.execute(() -> {
            log.debug("2");
        });

        pool.execute(() -> {
            log.debug("3");
        });
    }

    //带缓冲的线程池:全部都是救急线程（60s 后可以回收）,救急线程可以无限创建
    public static void test3() {
        ExecutorService pool = Executors.newCachedThreadPool();
    }

    //带任务调度线程池：相比单线程的Timer，任务可以并行执行,异常不会影响其他任务
    public static void test4() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        pool.schedule(() -> {
            log.debug("task1");
            int i = 1 / 0;
            Sleeper.sleep(1);
        }, 1, TimeUnit.SECONDS);

        pool.schedule(() -> {
            log.debug("task2");
            Sleeper.sleep(1);
        }, 1, TimeUnit.SECONDS);
    }

    //带任务调度线程池
    //scheduleAtFixedRate()：以固定速率调度任务，若任务本身执行时间超过了调度间隔，以实际执行时间为准
    //scheduleWithFixedDelay()：上一次任务执行结束后，间隔指定时间再次调度
    public static void test5() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        pool.scheduleAtFixedRate(() -> {
            log.debug("task1");
            Sleeper.sleep(2);
        }, 1, 1, TimeUnit.SECONDS);


        pool.scheduleWithFixedDelay(() -> {
            log.debug("task1");
            Sleeper.sleep(2);
        }, 1, 1, TimeUnit.SECONDS);
    }
}
