package com.github.archerda.jdk.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ArrayList toArray()测试
 * Created by luohd on 2016/8/19.
 */
public class ArrayListToArrayTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        /* it is ok. */
        Integer[] integers = {};
        integers = list.toArray(integers);
        System.out.println(Arrays.toString(integers));

        /* it is ok. */
        Object[] integers1 = list.toArray();
        System.out.print("[");
        for (int i = 0; i < integers1.length; ++i) {
            System.out.print(integers1[i] + ", ");
        }
        System.out.print("]");
        System.out.println();

        /* it will be wrong. */
        Integer[] integers2 = (Integer[]) list.toArray();
        System.out.println(Arrays.toString(integers2));

        Object[] objects = new Object[2];
        objects[0] = 1;
        objects[1] = 2;
        Integer[] integers3 = (Integer[]) objects;
        System.out.println(integers3);




    }
}
