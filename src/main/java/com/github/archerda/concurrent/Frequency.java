package com.github.archerda.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class Frequency {
    private  long maxCount; // 限制时间内执行的最大次数
    private  int limit; // 限制多久

    private AtomicLong num;
    private  long countTime;
    private  long slowTime;

    public Frequency(int maxCount, int limitSecond) {
        this.num = new AtomicLong(0);
        this.maxCount = maxCount;
        this.countTime = System.currentTimeMillis();
        this.limit = limitSecond * 1000;
        this.slowTime = 0;
    }

    public long incWait() throws InterruptedException {
        long count;
        if (slowTime != 0) {
            Thread.sleep(slowTime);
            slowTime = 0;
        }
        while (true) {
            count = this.num.incrementAndGet();
            if (count > maxCount) {
                Thread.sleep(100);
            } else {
                return count;
            }
            refreshTime();
        }
    }

    private synchronized void refreshTime() {
        long nowTime = System.currentTimeMillis();
        if (nowTime - countTime > limit) {
            this.num.set(0);
            this.countTime = nowTime;
        }
    }

    public void slowDown(long slowTime) {
        this.slowTime = slowTime;
    }


    public static void main(String[] args) throws InterruptedException {
        final Frequency frequency = new Frequency(10, 3);

        ExecutorService executors = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 10000; i++) {
            executors.execute(() -> {
                try {
                    frequency.incWait();
                    long current = System.currentTimeMillis();
                    System.out.println(current / 1000 + "：" + current);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


    }

}