package com.github.archerda.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 公用的线程池
 * @author chenzengyong
 * @date on 2015/11/25.
 */
public class CommonThreadPoolUtils {

    private static final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

    public static ExecutorService getExecutor(){
        return executor;
    }
}
