package com.github.archerda.advices151;

import java.util.Arrays;
import java.util.List;

/**
 * 原始类型数组不能作为Arrays.asList()的入参, 否则会引起程序逻辑错误.
 *
 * Created by luohd on 16/12/26.
 */
public class ArraysAsList65 {

    public static void main(String[] args) {

        // 错误代码
        int[] data = {1, 2, 3, 4};
        List list = Arrays.asList(data);
        System.out.println("元素类型:" + list.get(0).getClass());
        System.out.println("前后是否相等: " + data.equals(list.get(0)));
        // 运行结果:
        // 元素类型:class [I
        // 前后是否相等: true

        // 正确代码
        Integer[] data2 = {1, 2, 3, 4};
        List<Integer> list2 = Arrays.asList(data2);
        System.out.println("元素类型:" + list2.get(0).getClass());
        System.out.println("前后是否相等: " + data2.equals(list2.get(0)));
        // 运行结果:
        // 元素类型:class java.lang.Integer
        // 前后是否相等: false
    }
}
