package com.github.archerda.jdk.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ArrayList遍历方式和效率的测试程序。
 */
public class ArrayListTraverseTest {

    public static void main(String[] args) {
        Integer size = 100000;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        randomAccessToTraverse(list);
        iteratorToTraverse(list);
        foreachToTraverse(list);

    }

    public static void randomAccessToTraverse(List list) {
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        endTime = System.currentTimeMillis();

        long interval = endTime - startTime;
        System.out.println("randomAccessToTraverse：" + interval + " ms");
    }

    public static void iteratorToTraverse(List list) {
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            iter.next();
        }
        endTime = System.currentTimeMillis();

        long interval = endTime - startTime;
        System.out.println("iteratorToTraverse：" + interval + " ms");
    }


    public static void foreachToTraverse(List list) {
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        for (Object obj : list)
            ;
        endTime = System.currentTimeMillis();

        long interval = endTime - startTime;
        System.out.println("foreachToTraverse：" + interval + " ms");
    }
}