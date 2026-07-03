package com.bistu.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {
    public static void main(String[] args) {
        //ExecutorService pool = Executors.newCachedThreadPool();
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.submit(new ThreadPool());
        pool.submit(new ThreadPool());
        pool.submit(new ThreadPool());
        pool.submit(new ThreadPool());
        pool.submit(new ThreadPool());

        pool.shutdown();

    }
}
