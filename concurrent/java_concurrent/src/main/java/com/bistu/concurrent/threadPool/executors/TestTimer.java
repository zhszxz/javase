package com.bistu.concurrent.threadPool.executors;

import com.bistu.concurrent.util.Sleeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;

//Timer实现定时功能
//由于所有任务都是由同一个线程来调度，因此所有任务都是串行执行的，同一时间只能有一个任务在执行
// 前一个任务的延迟或异常都将会影响到之后的任务。
public class TestTimer {
    private static final Logger log = LoggerFactory.getLogger(TestTimer.class);

    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                log.debug("task 1");
                Sleeper.sleep(2);
            }
        };
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                log.debug("task 2");
            }
        };
        timer.schedule(task1, 1000);
        timer.schedule(task2, 1000);
    }
}
