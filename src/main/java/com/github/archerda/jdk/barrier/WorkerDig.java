package com.github.archerda.jdk.barrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Barrier测试: 让多线程同步走
 * Created by luohd on 17/1/12.
 */
public class WorkerDig {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        int num = 10;

        CyclicBarrier barrier = new CyclicBarrier(num, () -> System.out.println("隧道打通了"));

        // 工人开始挖隧道
        for (int i = 0; i < num; ++i) {
            new Thread(new Worker(barrier), "工人" + i).start();
        }
    }

}

class Worker implements Runnable {

    private CyclicBarrier barrier;

    public Worker(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
            System.out.println(Thread.currentThread().getName() + "到达汇合点了");

            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
