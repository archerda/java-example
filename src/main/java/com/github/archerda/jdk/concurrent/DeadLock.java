package com.github.archerda.jdk.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * 死锁示例；
 *
 * @author archerda
 * @date 2018/6/28
 */
public class DeadLock {

    public static void main(String[] args) throws InterruptedException {

        Object resourceA = new Object();
        Object resourceB = new Object();

        Thread threadLockingResourceAFirst = new Thread(new DeadLockRunnable(resourceA, resourceB));
        Thread threadLockingResourceBFirst = new Thread(new DeadLockRunnable(resourceB, resourceA));

        threadLockingResourceAFirst.start();
        TimeUnit.MILLISECONDS.sleep(500);
        threadLockingResourceBFirst.start();
    }

    private static class DeadLockRunnable implements Runnable {

        private final Object firstResource;
        private final Object secondResource;

        public DeadLockRunnable(Object firstResource, Object secondResource) {
            this.firstResource = firstResource;
            this.secondResource = secondResource;
        }

        @Override
        public void run() {

            try {
                synchronized (firstResource) {

                    printLockedResource(firstResource);

                    TimeUnit.MILLISECONDS.sleep(1000);

                    synchronized (secondResource) {
                        printLockedResource(secondResource);
                    }

                }
            } catch (InterruptedException e) {
                System.out.println("Exception occurred: " + e);
            }

        }

        private static void printLockedResource(Object resource) {
            System.out.println(Thread.currentThread().getName() + ": locked resource -> " + resource);
        }
    }
}
