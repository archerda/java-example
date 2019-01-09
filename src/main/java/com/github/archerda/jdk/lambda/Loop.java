package com.github.archerda.jdk.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by luohd on 2016/7/28.
 */
public class Loop {

    private static void timer(Consumer<List<Integer>> func, List<Integer> param, String id) {
        long start = System.nanoTime();
        func.accept(param);
        long end = System.nanoTime();
        System.out.println(id + " cost: " + (end - start) + " ns");
    }

    private static void foriLoop(List<Integer> names) {
        for (int i = 0; i < names.size(); i++) {
            Integer integer = names.get(i);
            // TODO
        }
    }

    private static void forEachLoop(List<Integer> names) {
        for (Integer integer : names) {
            // TODO
        }
    }

    private static void streamLoop(List<Integer> names) {
        names.stream().forEach(integer -> {
            // TODO
        });
    }

    public static void main(String[] args) {
        List<Integer> names = new ArrayList<>();
        //List<Integer> names = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            names.add(i);
        }
        timer(Loop::foriLoop, names, "foriloop");
        timer(Loop::forEachLoop, names, "forEachloop");
        timer(Loop::streamLoop, names, "streamLoop");
    }

    private static void timer2(Consumer<List<Integer>> func, List<Integer> list, String id) {
        func.accept(list);
    }

}