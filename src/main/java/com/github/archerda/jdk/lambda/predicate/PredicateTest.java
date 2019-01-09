package com.github.archerda.jdk.lambda.predicate;

import java.util.function.Predicate;

/**
 * Create by archerda on 2016/11/29
 */
public class PredicateTest {

    private static final Predicate<String> PREDICATE = "hello"::equals;

    public static void main(String[] args) {

        System.out.println(PREDICATE.test("hello"));
        System.out.println(PREDICATE.test("hello2"));
    }
}
