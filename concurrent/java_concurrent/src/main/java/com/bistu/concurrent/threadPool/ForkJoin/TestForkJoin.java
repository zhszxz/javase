package com.bistu.concurrent.threadPool.ForkJoin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join 是 JDK 1.7 加入的新的线程池实现，它体现的是一种分治思想，适用于能够进行任务拆分的cpu密集型运算
 * Fork/Join 在分治的基础上加入了多线程，可以把每个任务的分解和合并交给不同的线程来完成，进一步提升了运算效率
 * Fork/Join 默认会创建与 cpu 核心数大小相同的线程池
 */
public class TestForkJoin {
    private static final Logger log = LoggerFactory.getLogger(TestForkJoin.class);

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.invoke(new MyTask(5)));
    }
}

//提交给 Fork/Join 线程池的任务需要继承 RecursiveTask（有返回值）或 RecursiveAction（没有返回值）
class MyTask extends RecursiveTask<Integer> {
    private static final Logger log = LoggerFactory.getLogger(MyTask.class);

    private int n;

    public MyTask(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "{" + n + '}';
    }

    @Override
    protected Integer compute() {
        // 如果 n 已经为 1，可以求得结果了
        if (n == 1) {
            log.debug("join() {}", n);
            return n;
        }

        // 将任务进行拆分(fork)
        MyTask task = new MyTask(n - 1);
        task.fork();
        log.debug("fork() {} + {}", n, task);

        // 合并(join)结果
        int result = n + task.join();
        log.debug("join() {} + {} = {}", n, task, result);
        return result;
    }
}


