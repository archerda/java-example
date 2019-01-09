package com.github.archerda.jdk.latch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * CountDownLatch测试: 使用CDL协调子线程
 * Created by luohd on 17/1/11.
 */
public class RunnerTest {

    public static void main(String[] args) throws Exception {
        // 参赛人数
        int num = 10;

        // 发令枪只响一次
        CountDownLatch begin = new CountDownLatch(1);

        // 每个运动员跑完都要通知一下
        CountDownLatch end = new CountDownLatch(num);

        // 每个运动员一条跑道
        ExecutorService exe = Executors.newFixedThreadPool(num);

        // 有多个计分器
        List<Future<Integer>> scoreList = new ArrayList<>(num);

        // 运动员就位, 等待发令枪
        for (int i = 0; i < num; ++i) {
            scoreList.add(exe.submit(new Runner(begin, end)));
        }

        // 发令枪发令
        begin.countDown();

        // 等待运动员跑步完成
        // 注意不要写成wait.
        end.await();

        // 所有运动员都跑完了, 开始公布分数
        for (Future<Integer> future : scoreList) {
            System.out.println(future.get());
        }

    }

}

class Runner implements Callable<Integer> {

    private CountDownLatch begin;
    private CountDownLatch end;

    public Runner(CountDownLatch begin, CountDownLatch end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int score = new Random().nextInt(25);

        // 等待枪声响起(等待主线程countdown)
        begin.await();

        // 枪声已经响了, 开始赛跑(主线程countdown了, 这个线程开始执行)
        System.out.println("run");
        TimeUnit.MILLISECONDS.sleep(score);

        // 跑完了(这个线程要执行完了, 把主线程countdown)
        end.countDown();

        return score;
    }
}
