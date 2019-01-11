package com.github.archerda.guava;

import com.google.common.util.concurrent.RateLimiter;

import com.github.archerda.concurrent.threadpool.CommonThreadPoolUtils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.concurrent.CountDownLatch;

/**
 * @author archerda
 */
public class RateLimiting {

    public static void main(String[] args) throws InterruptedException {

        /*
        RateLimiter 是采用 令牌桶 实现。
        支持预消费，比如目前桶中只有1个令牌，但acquire(10)是可以成功的，后续的acquire要等预消费的9个token生成后才可以继续获取；
         */

        RateLimiter rateLimiter = RateLimiter.create(1.0);
        CountDownLatch countDownLatch = new CountDownLatch(1);

        CommonThreadPoolUtils.getExecutor().submit(() -> {

            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            rateLimiter.acquire(10);
            System.out.println(DateFormatUtils.ISO_DATETIME_FORMAT.format(System.currentTimeMillis()) + " I got 10 permits");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        CommonThreadPoolUtils.getExecutor().submit(() -> {

            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            rateLimiter.acquire(3);
            System.out.println(DateFormatUtils.ISO_DATETIME_FORMAT.format(System.currentTimeMillis()) + " I got 3 permits");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        countDownLatch.countDown();
    }
}
