package com.github.archerda.designpattern.singleton.destory.serialization;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用同步方式实现单例，并且实现序列化接口
 *
 * Create by archerda on 2017/11/12.
 */
public class Singleton implements Serializable {

    private static final long serialVersionUID = -8646622406647124406L;

    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Singleton> future1 = executorService.submit(Singleton::getInstance);
        Future<Singleton> future2 = executorService.submit(Singleton::getInstance);
        System.out.println(future1.get() == future2.get());
        executorService.shutdown();
    }
}
