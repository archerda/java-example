package com.github.archerda.jdk.juc.collectionandmap;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Create by archerda on 2018/04/12.
 */
public class CopyOnWriteArraySetTest {

    public static void main(String[] args) {
        testSort();
    }

    // 测试CopyOnWriteArraySet是不是有序的;
    // 结果: CopyOnWriteArraySet是有序的;
    // 原因: CopyOnWriteArraySet是依赖CopyOnWriteArrayList来实现的;
    private static void testSort() {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.add("robert");
        copyOnWriteArraySet.add("luohuida");
        copyOnWriteArraySet.add("archerda");

        for (String aCopyOnWriteArraySet : copyOnWriteArraySet) {
            System.out.println(aCopyOnWriteArraySet);
        }
    }
}
