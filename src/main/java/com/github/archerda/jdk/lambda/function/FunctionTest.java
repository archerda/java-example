package com.github.archerda.jdk.lambda.function;

import java.util.function.Function;

/**
 * Create by archerda on 2016/11/29
 */
public class FunctionTest {

    private static final Function<String, String> FUNCTION = String::toUpperCase;

    public static void main(String[] args) {
        System.out.println(FUNCTION.apply("hello"));
        System.out.println(FUNCTION.apply("hello2"));
    }
}
