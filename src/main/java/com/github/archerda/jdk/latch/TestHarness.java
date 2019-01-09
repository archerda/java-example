package com.github.archerda.jdk.latch;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁
 * Created by luohd on 16/10/20.
 */
public class TestHarness {

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; ++i) {
            Thread t = new Thread(() -> {
                try {
                    startGate.await();
                    try {
                        task.run();
                    } finally {
                        endGate.countDown();
                    }
                } catch (InterruptedException ignored) {
                }
            });
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        return System.nanoTime() - start;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new TestHarness().timeTasks(10, () -> System.out.println("hhhhh")));
    }


}
