package com.bistu.concurrent.fulture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TestCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 创建CompletableFuture对象：
         * 通过 new 关键字。
         * 基于 CompletableFuture 自带的静态工厂方法：runAsync()、supplyAsync()
         * 需要异步操作且不关心返回结果的时候可以使用 runAsync() 方法
         * 需要异步操作且关心返回结果的时候,可以使用 supplyAsync() 方法
         */
        CompletableFuture<Integer> resultFuture = new CompletableFuture<>();
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> System.out.println("hello"));
        //阻塞等待执行结果
        future1.get();
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "hello");
        String string = future2.get();
        System.out.println(string);

        /**
         * 当我们获取到异步计算的结果之后，还可以对其进行进一步的处理，比较常用的方法有下面几个：
         *
         * thenApply()
         * thenAccept()
         * thenRun()
         * whenComplete()
         */
        //thenApply() 方法接受一个 Function 实例，用它来处理结果
        CompletableFuture<String> future3 = CompletableFuture.completedFuture("hello")
                .thenApply(s -> s + "world!");
        System.out.println(future3.get());
        //如果你不需要从回调函数中获取返回结果，可以使用 thenAccept() 或者 thenRun()
        //这两个方法的区别在于 thenRun() 不能访问异步计算的结果
        CompletableFuture.completedFuture("hello!")
                .thenApply(s -> s + "world!").thenApply(s -> s + "nice!").thenAccept(System.out::println);//hello!world!nice!

        CompletableFuture.completedFuture("hello!")
                .thenApply(s -> s + "world!").thenApply(s -> s + "nice!").thenRun(() -> System.out.println("hello!"));//hello!
        //whenComplete() 的方法的参数是 BiConsumer, 可以接收 2 个输入对象然后进行“消费”
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> "hello!")
                .whenComplete((res, ex) -> {
                    // res 代表返回的结果
                    // ex 的类型为 Throwable ，代表抛出的异常
                    System.out.println(res);
                    if (ex != null)
                        ex.printStackTrace();
                });

        //通过 handle() 方法来处理任务执行过程中可能出现的抛出异常的情况
        CompletableFuture<String> future5
                = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException("Computation error!");
            }
            return "hello!";
        }).handle((res, ex) -> {
            // res 代表返回的结果
            // ex 的类型为 Throwable ，代表抛出的异常
            return res != null ? res : "world!";
        });

        //thenCompose() 按顺序链接两个 CompletableFuture 对象，实现异步的任务链
        //它的作用是将前一个任务的返回结果作为下一个任务的输入参数，从而形成一个依赖关系
        //thenCompose() 和 thenCombine() 有什么区别:
        //thenCompose() 可以链接两个 CompletableFuture 对象，并将前一个任务的返回结果作为下一个任务的参数，它们之间存在着先后顺序。
        //thenCombine() 会在两个任务都执行完成后，把两个任务的结果合并。两个任务是并行执行的，它们之间并没有先后依赖顺序。
        CompletableFuture<String> future6
                = CompletableFuture.supplyAsync(() -> "hello!")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "world!"));
        System.out.println(future6.get());
    }
}
