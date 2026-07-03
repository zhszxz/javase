package com.bistu.concurrent.threadPool.methods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.*;

/**
 * shutdown():关闭线程池
 * 线程池状态变为 SHUTDOWN
 * - 不会接收新任务
 * - 但已提交任务会执行完
 * - 此方法不会阻塞调用线程的执行
 */

/**
 * shutdownNow():关闭线程池
 * 线程池状态变为 STOP
 * - 不会接收新任务
 * - 会将队列中的任务返回
 * - 并用 interrupt 的方式中断正在执行的任务
 */
public class TestShutDown {
    private static final Logger log = LoggerFactory.getLogger(TestShutDown.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future<Integer> result1 = pool.submit(() -> {
            log.debug("task 1 running...");
            Thread.sleep(1000);
            log.debug("task 1 finish...");
            return 1;
        });

        Future<Integer> result2 = pool.submit(() -> {
            log.debug("task 2 running...");
            Thread.sleep(1000);
            log.debug("task 2 finish...");
            return 2;
        });

        Future<Integer> result3 = pool.submit(() -> {
            log.debug("task 3 running...");
            Thread.sleep(1000);
            log.debug("task 3 finish...");
            return 3;
        });

        log.debug("shutdown");
        //pool.shutdown();
        //等待，直到线程池中的线程执行完或超时
        //pool.awaitTermination(3, TimeUnit.SECONDS);
        List<Runnable> runnables = pool.shutdownNow();
        log.debug("other.... {}", runnables);
    }
}
