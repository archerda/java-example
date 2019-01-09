package com.github.archerda.jdk.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by luohd on 16/12/28.
 */
public class CoreSizeZero {

    public static void main(String[] args) throws InterruptedException {

        // 如果coreSize=0, 那么线程池最大就只有1个线程, 等同于设置coreSize=1
        // ExecutorService executorService = new ThreadPoolExecutor(
        //         0,
        //         Integer.MAX_VALUE,
        //         60L,
        //         TimeUnit.SECONDS,
        //         new LinkedBlockingDeque<>());
        //
        // executorService.execute(new InnerTask());
        // executorService.execute(new InnerTask());
        // executorService.execute(new InnerTask());
        // executorService.execute(new InnerTask());
        // executorService.execute(new InnerTask());
        // executorService.execute(new InnerTask());
        // executorService.execute(new InnerTask());
        //
        // executorService.shutdown();

        // 如果工作队列是 ArrayBlockingQueue有界队列, 队列容量为3, 那么线程池的线程数最多为3,
        // 工作队列最多放3个任务. 第七个任务提交时, 触发饱和策略, 任务被拒绝, 线程池抛出RejectedExecutionException异常.
        // ExecutorService executorService2 = new ThreadPoolExecutor(
        //         0,
        //         3,
        //         60L,
        //         TimeUnit.SECONDS,
        //         new ArrayBlockingQueue<>(3));
        //
        // executorService2.execute(new InnerTask());
        // executorService2.execute(new InnerTask());
        // executorService2.execute(new InnerTask());
        // executorService2.execute(new InnerTask());
        // executorService2.execute(new InnerTask());
        // executorService2.execute(new InnerTask());
        // executorService2.execute(new InnerTask());
        //
        // executorService2.shutdown();

        // 如果工作队列是 SynchronousQueue(同步移交), 当第七个任务提交的时候, 没有空闲线程,
        // 并且已达到最大线程数,  触发饱和策略.
        ExecutorService executorService3 = new ThreadPoolExecutor(
                0,
                Integer.MAX_VALUE,
                60L,
                TimeUnit.SECONDS,
                new SynchronousQueue<>());

        executorService3.execute(new InnerTask());
        executorService3.execute(new InnerTask());
        executorService3.execute(new InnerTask());
        executorService3.execute(new InnerTask());
        executorService3.execute(new InnerTask());
        executorService3.execute(new InnerTask());
        executorService3.execute(new InnerTask());

        executorService3.shutdown();
    }

    private static class InnerTask extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
