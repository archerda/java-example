package com.github.archerda.jdk.juc.lock;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁
 * Create by archerda on 2018/03/30.
 */
public class CountDownLatchTest {


    private static final int LATCH_SIZE = 5;
    private static CountDownLatch doneSignal;

    public static void main(String[] args) {

        try {

            doneSignal = new CountDownLatch(LATCH_SIZE);

            // 新建5个任务
            for (int i = 0; i < LATCH_SIZE; i++)
                new InnerThread().start();

            System.out.println("main await begin.");
            // "主线程"等待线程池中5个任务的完成
            doneSignal.await();

            System.out.println("main await finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class InnerThread extends Thread {
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " sleep 1000ms.");
                Thread.sleep(1000);
                // 将CountDownLatch的数值减1
                doneSignal.countDown();
                System.out.println(Thread.currentThread().getName() + " go!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
