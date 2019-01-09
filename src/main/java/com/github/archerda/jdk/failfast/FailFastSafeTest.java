package com.github.archerda.jdk.failfast;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * fail-fast机制示例
 * Created by luohd on 2016/8/24.
 */
public class FailFastSafeTest {

    private static List<Integer> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {

        /* 同时启动两个线程 */
        //new ThreadOne("ThreadOne").start();
        //new ThreadTwo("ThreadTwo").start();

        list.add(0);
        list.add(1);
        list.add(2);
        Iterator<Integer> integerIterator = list.iterator();
        list.remove(0);
        System.out.println(Arrays.toString(list.toArray()));

        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }


        Object[] a = {1, 2, 3};
        Object[] b = a;
        a[0] = 5;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

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
