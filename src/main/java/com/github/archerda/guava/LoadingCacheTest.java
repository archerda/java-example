package com.github.archerda.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author luohuida
 */
public class LoadingCacheTest {

    private static StopWatch stopWatch;

    public static void main(String[] args) throws Exception {
        stopWatch = new StopWatch();
        stopWatch.start();
        LoadingCache<Integer, String> cache = CacheBuilder.newBuilder()
            .refreshAfterWrite(5, TimeUnit.SECONDS)
            .expireAfterWrite(10, TimeUnit.SECONDS)
            .build(new CacheLoader<Integer, String>() {
                @Override
                public String load(Integer key) throws Exception {
                    return queryData(key);
                }
            });
        // 没缓存，同步获取，2个线程都必须等待；
        Thread thread1 = startLoadingCacheQuery("client1", cache);
        Thread thread2 = startLoadingCacheQuery("client2", cache);
        thread1.join();
        thread2.join();

        // 有缓存，两个线程都可以直接从缓存获取到数据；
        Thread thread3 = startLoadingCacheQuery("client3", cache);
        Thread thread4 = startLoadingCacheQuery("client4", cache);
        thread3.join();
        thread4.join();

        // 缓存需要refresh，refresh的线程需要同步等待，其他线程不用等待，直接获取到旧数据；
        Thread.sleep(5000);
        Thread thread5 = startLoadingCacheQuery("client5", cache);
        Thread thread6 = startLoadingCacheQuery("client6", cache);
        thread5.join();
        thread6.join();

        // 缓存expire需要load，同步获取，2个线程都必须等待；
        Thread.sleep(10000);
        Thread thread7 = startLoadingCacheQuery("client7", cache);
        Thread thread8 = startLoadingCacheQuery("client8", cache);
        thread7.join();
        thread8.join();
    }

    private static String queryData(Integer key) throws InterruptedException {
        log("queryData start");
        Thread.sleep(3000);
        log("queryData end");
        return key.toString();
    }

    private static Thread startLoadingCacheQuery(String clientName, LoadingCache<Integer, String> cache) {
        Thread thread = new Thread(() -> {
            log("get start");
            try {
                cache.get(1);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            log("get end");
        });
        thread.setName(clientName);
        thread.start();
        return thread;
    }

    private static void log(String msg) {
        System.out.println(
            String.format("%ds %s %s", stopWatch.getTime() / 1000, Thread.currentThread().getName(), msg));
    }
}
