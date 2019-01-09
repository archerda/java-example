package com.github.archerda.jdk.lambda;

import java.time.Clock;
import java.util.*;
import java.util.function.Predicate;

/**
 * lambda范例
 * Created by luohd on 2016/7/28.
 */
public class TestLambda {

    public static void runThreadUseLambda() {
        new Thread(() -> {
            System.out.println("runThreadUseLambda1");
            System.out.println("runThreadUseLambda11");
        }).start();
    }

    public static void runThreadUserInnerClass() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runThreadUseLambda2");
            }
        }).start();
    }

    public static void filter(List<String> names, Predicate condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }

    public static void compare(List<String> names) {
        Collections.sort(names, String::compareTo);
    }

    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        stringCollection.stream().filter((s) -> s.startsWith("a"))
                .filter((s) -> s.contains("1")).forEach(System.out::println);

        stringCollection.stream().sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);

        //map
        stringCollection.stream().map(String::toLowerCase).forEach(System.out::println);

        //reduce
        Optional<String> reduced = stringCollection.stream().reduce((a, b) -> a + ":" + b);
        reduced.ifPresent(System.out::println);

        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());

        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        long t0 = System.nanoTime();
        long count1 = values.stream().sorted().count();
        System.out.println("count1" + count1);
        long t1 = System.nanoTime();
        System.out.println(t1 - t0);

        long t2 = System.nanoTime();
        long count2 = values.parallelStream().sorted().count();
        System.out.println("count2" + count2);
        long t3 = System.nanoTime();
        System.out.println(t3 - t2);

    }
}
