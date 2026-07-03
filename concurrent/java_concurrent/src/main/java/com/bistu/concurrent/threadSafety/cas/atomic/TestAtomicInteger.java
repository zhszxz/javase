package com.bistu.concurrent.threadSafety.cas.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

public class TestAtomicInteger {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(5);
        System.out.println(i.incrementAndGet());
        System.out.println(i.getAndIncrement());
        System.out.println(i.getAndAdd(5));
        System.out.println(i.addAndGet(5));
        i.updateAndGet(value -> value * 10);
        System.out.println(updateAndGet(i, p -> p / 2));
        System.out.println(i.get());
    }

    public static int updateAndGet(AtomicInteger i, IntUnaryOperator operator) {
        while (true) {
            int prev = i.get();
            int next = operator.applyAsInt(prev);
            if (i.compareAndSet(prev, next)) {
                return next;
            }
        }
    }
}
