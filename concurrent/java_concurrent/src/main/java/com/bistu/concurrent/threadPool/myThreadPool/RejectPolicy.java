package com.bistu.concurrent.threadPool.myThreadPool;

//拒绝策略
@FunctionalInterface
public interface RejectPolicy<T> {
    void reject(BlockingQueue<T> queue, T task);
}
