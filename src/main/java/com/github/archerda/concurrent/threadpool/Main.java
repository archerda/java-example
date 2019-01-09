package com.github.archerda.concurrent.threadpool;

import java.util.concurrent.TimeUnit;

/**
 * Create by archerda on 2018/01/16.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("main thread start...");

        CommonThreadPoolUtils.getExecutor().execute(() -> {
            System.out.println("thread 1 start...");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread 1 end...");
        });

        CommonThreadPoolUtils.getExecutor().execute(() -> {
            System.out.println("thread 2 start...");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread 2 end...");
        });

        System.out.println("main thread end...");
        // System.exit(0); 结束进程
    }
}
