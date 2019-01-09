package com.github.archerda.designpattern.singleton.eagerly;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 饿汉式
 *
 * Create by archerda on 2017/11/12.
 */
public class Singleton {

    // 类加载的时候就会初始化，这个过程有且仅有一次
    private static final Singleton instance = new Singleton();

    // 私有的构造方法
    private Singleton() {}

    // 对外提供唯一的Singleton实例
    public static Singleton getInstance() {
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
