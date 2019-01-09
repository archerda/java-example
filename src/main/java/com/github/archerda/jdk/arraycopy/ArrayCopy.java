package com.github.archerda.jdk.arraycopy;

/**
 * Java中数组拷贝的3种方式效率比较
 * Created by luohd on 2016/9/7.
 */
public class ArrayCopy {

    private static final int SIZE = 20000000;

    public static void main(String[] args) throws Exception{
        String[] arr1 = new String[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            arr1[i] = String.valueOf(i);
        }

        copyByLoop(arr1);

        String[] arr2 = new String[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            arr2[i] = String.valueOf(i);
        }
        copyByClone(arr2);

        String[] arr3 = new String[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            arr3[i] = String.valueOf(i);
        }
        copyBySystemCopy(arr3);
    }

    /* 循环拷贝 */
    private static void copyByLoop(String[] arr) {
        Long startTime = System.currentTimeMillis();
        String[] destArray = new String[SIZE];
        for (int i = 0; i < arr.length; i++) {
            destArray[i] = arr[i];
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("copyByLoop cost: " + (endTime - startTime));
    }

    /* 克隆函数拷贝 */
    private static void copyByClone(String[] arr) {
        Long startTime = System.currentTimeMillis();
        String[] destArray = arr.clone();
        Long endTime = System.currentTimeMillis();
        System.out.println("copyByClone cost: " + (endTime - startTime));
    }

    /* System.arraycopy拷贝 */
    private static void copyBySystemCopy(String[] arr) {
        Long startTime = System.currentTimeMillis();
        String[] destArray = new String[SIZE];
        System.arraycopy(arr, 0, destArray, 0, arr.length);
        Long endTime = System.currentTimeMillis();
        System.out.println("copyBySystemCopy cost: " + (endTime - startTime));
    }

}
