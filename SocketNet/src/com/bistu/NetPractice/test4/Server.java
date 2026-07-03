package com.bistu.NetPractice.test4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    public static void main(String[] args) throws IOException {
        //绑定端口
        ServerSocket ss = new ServerSocket(10086);

        //创建线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 16, 5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());


        while (true) {
            //等待连接
            Socket socket = ss.accept();
            //提交线程的任务对象
            pool.submit(new MyThread(socket));
        }
    }
}

