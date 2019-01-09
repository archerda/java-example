package com.github.archerda.jdk.failfast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * fail-fast机制示例
 * Created by luohd on 2016/8/24.
 */
public class FailFastUnsafeTest {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        /* 同时启动两个线程 */
        new ThreadOne("ThreadOne").start();
        new ThreadTwo("ThreadTwo").start();

    }

    private static void printAll() {

        /* 用迭代器来遍历集合 */
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    private static class ThreadOne extends Thread {

        ThreadOne(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; ++i) {
                list.add(i);
                printAll();
            }
        }

    }

    private static class ThreadTwo extends Thread {

        ThreadTwo(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 10; i < 20; ++i) {
                list.add(i);
                printAll();
            }
        }

    }




}
