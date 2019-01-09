package com.github.archerda.advices151;

import java.util.ArrayList;
import java.util.List;

/**
 * Java的泛型是类型擦除的
 * Created by luohd on 16/12/29.
 */
public class GenericErasure93 {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        System.out.println(strings.getClass() == integers.getClass());
    }

    // public void listMethod(List<Integer> integers) {
    //
    // }
    //
    // public void listMethod(List<String> strings) {
    //
    // }
}
