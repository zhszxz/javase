package com.bistu.concurrent.immutable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class TestImmutable {
    private static final Logger log = LoggerFactory.getLogger(TestImmutable.class);

    public static void main(String[] args) {
        //可变类在多线程环境下可能存在线程安全问题
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    log.debug("{}", sdf.parse("1951-04-21"));
                } catch (Exception e) {
                    log.error("{}", e);
                }
            }).start();
        }*/


        DateTimeFormatter stf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                TemporalAccessor parse = stf.parse("1951-04-21");
                log.debug("{}", parse);
            }).start();
        }
    }


}
