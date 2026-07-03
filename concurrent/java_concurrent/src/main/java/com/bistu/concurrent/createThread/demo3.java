package com.bistu.concurrent.createThread;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//创建线程方式三:FutureTask结合Thread，可以拿到线程执行结果
public class demo3 {

    private static final Logger log = LoggerFactory.getLogger(demo3.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.info("running......");
                Thread.sleep(1000);
                return 10;
            }
        });

        new Thread(task).start();

        //主线程阻塞等待执行结果
        Integer result = task.get();
        log.info("线程执行结果是：{}",result);
    }
}
