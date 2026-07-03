package com.bistu.concurrent.threadPool.methods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestSubmit {
    private static final Logger log = LoggerFactory.getLogger(TestSubmit.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        method(Executors.newSingleThreadExecutor());
    }

    //submit():向线程池提交任务，可以获取返回结果
    private static void method(ExecutorService pool) throws InterruptedException, ExecutionException {
        Future<String> future = pool.submit(() -> {
            log.debug("running");
            Thread.sleep(1000);
            return "ok";
        });

        log.debug("{}", future.get());
    }

}
