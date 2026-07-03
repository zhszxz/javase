package com.bistu.Thread;

import java.util.concurrent.Callable;

public class MyThread3 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Integer result=0;
        for(int i=1;i<=100;i++){
            result+=i;
        }
        return result;
    }
}
