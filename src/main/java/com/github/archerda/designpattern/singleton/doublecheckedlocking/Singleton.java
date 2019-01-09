package com.github.archerda.designpattern.singleton.doublecheckedlocking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 双重校验锁
 *
 * Create by archerda on 2017/11/12.
 */
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if(instance == null){// 第一次校验
            synchronized (Singleton.class){// 锁
                if(instance == null){// 第二次校验
                    instance = new Singleton();// a：可加赋值的内存屏障
                }
            }
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
