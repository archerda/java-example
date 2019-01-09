package com.github.archerda.algorithm.sort;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * 快速排序使用分治法（Divide and conquer）策略来把一个序列（list）分为两个子序列（sub-lists）。
 *
 * 步骤为：
 *
 * 1. 从数列中挑出一个元素，称为“基准”（pivot），
 * 2. 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任何一边）。
 * 在这个分割结束之后，该基准就处于数列的中间位置。这个称为分割（partition）操作。
 * 3. 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * 递归到最底部时，数列的大小是零或一，也就是已经排序好了。这个算法一定会结束，因为在每次的迭代（iteration）中，
 * 它至少会把一个元素摆到它最后的位置去。
 *
 * 排序算法	平均情况	    最好情况	    最坏情况	  辅助空间	        稳定性
 * 快速排序	O(nlogn)	O(nlogn)	O(n^2)	  O(logn)~log(n)	不稳定
 *
 * @see "http://wiki.jikexueyuan.com/project/easy-learn-algorithm/fast-sort.html"
 * @author archerda
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quickSort(a, 0, 9);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a, int begin, int end) {

        if (ArrayUtils.isEmpty(a) || begin < 0 || end < 0 || begin > end) {
            return;
        }

        if (begin < end) {

            int i = begin;
            int j = end;
            //p中存的就是基准数
            int p = a[begin];
            int tmp;

            while (i < j) {

                //顺序很重要，要先从右边开始找
                while (i < j && a[j] >= p) {
                    j--;
                }

                //再找左边的
                while (i < j && a[i] <= p) {
                    i++;
                }

                //交换两个数在数组中的位置
                if (i < j) {
                    tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }

            //最终将基准数归位
            a[begin] = a[i];
            a[i] = p;

            //继续处理左边的，这里是一个递归的过程
            quickSort(a, begin, i - 1);
            //继续处理右边的 ，这里是一个递归的过程
            quickSort(a, i + 1, end);
        }
    }
}
