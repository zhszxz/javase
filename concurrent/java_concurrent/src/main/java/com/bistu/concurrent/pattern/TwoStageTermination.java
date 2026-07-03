package com.bistu.concurrent.pattern;

import com.bistu.concurrent.methods.demo6;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TwoStageTermination {
    public static void main(String[] args) throws InterruptedException {
        Monitor monitor = new Monitor();
        monitor.start();
        Thread.sleep(5000);
        monitor.stop();
    }

}

class Monitor {

    private Thread monitor;

    private volatile boolean stop = false;

    private final Logger log = LoggerFactory.getLogger(demo6.class);

    public void start() {
        monitor = new Thread(() -> {
            /*while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    log.debug("料理后事......");
                    break;
                }
                log.debug("监控记录......");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //由于打断标志被重置为false，需要重新设置
                    Thread.currentThread().interrupt();
                }
            }*/
            while (true) {
                if (stop) {
                    log.debug("料理后事......");
                    break;
                }
                log.debug("监控记录......");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        });
        monitor.start();
    }

    public void stop() {
        //monitor.interrupt();
        stop = true;
        monitor.interrupt();
    }
}
