package com.github.archerda.designpattern.singleton.enumway;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Create by archerda on 2017/11/12.
 */
public enum Singleton {
    INSTANCE;

    public static Singleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Singleton> future1 = executorService.submit(Singleton::getInstance);
        Future<Singleton> future2 = executorService.submit(Singleton::getInstance);
        System.out.println(future1.get() == future2.get());
        executorService.shutdown();
    }
}
