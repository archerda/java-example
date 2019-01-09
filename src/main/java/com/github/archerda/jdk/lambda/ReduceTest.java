package com.github.archerda.jdk.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by luohd on 16/10/31.
 */
public class ReduceTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("12");
        list.add("233");

        System.out.println(list.stream().collect(Collectors.joining(",")));
    }
}
