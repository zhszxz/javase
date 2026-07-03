package com.bistu.ThreadPool;

public class test2 {
    public static void main(String[] args) {
        //获取java虚拟机可用的逻辑处理器数（线程数）
        int count = Runtime.getRuntime().availableProcessors();
        System.out.println(count);

    }
}
