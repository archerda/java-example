package com.github.archerda.concurrent.threadpool;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by archerda on 16/01/2018.
 */
public class CommonThreadPoolUtilsTest {

    @Before
    public void setUp () {
        Thread.currentThread().getThreadGroup().setDaemon(false);
    }


    // junit环境中，单元测试线程结束后，junit会把整个进程结束掉，导致子线程会被终止；
    @Test
    public void testGetExecutor() throws InterruptedException {
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

        Thread.currentThread().join();
        System.out.println("main thread end...");
    }
}