package com.bistu.concurrent.threadPool.methods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestinvokeAny {
    private static final Logger log = LoggerFactory.getLogger(TestinvokeAny.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        method(Executors.newFixedThreadPool(3));
    }

    //invokeAny():批量提交任务，任意任务先成功执行完毕，返回执行结果，其它任务取消
    private static void method(ExecutorService pool) throws InterruptedException, ExecutionException {
        String result = pool.invokeAny(Arrays.asList(
                () -> {
                    log.debug("begin 1");
                    Thread.sleep(1000);
                    log.debug("end 1");
                    return "1";
                },
                () -> {
                    log.debug("begin 2");
                    Thread.sleep(500);
                    log.debug("end 2");
                    return "2";
                },
                () -> {
                    log.debug("begin 3");
                    Thread.sleep(2000);
                    log.debug("end 3");
                    return "3";
                }
        ));
        log.debug("{}", result);
    }

}
