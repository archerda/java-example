package com.github.archerda.designpattern.singleton.staticinnerclass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Create by archerda on 2017/11/12.
 */
public class Singleton {

    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton(){}

    public static final Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Singleton> future1 = executorService.submit(Singleton::getInstance);
        Future<Singleton> future2 = executorService.submit(Singleton::getInstance);
        System.out.println(future1.get() == future2.get());
        executorService.shutdown();
    }
}
