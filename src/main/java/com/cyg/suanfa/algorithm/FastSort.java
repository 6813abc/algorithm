package com.cyg.suanfa.algorithm;

import java.util.Random;

/**
 * 快速排序的原理:选择一个关键值作为基准值。
 * 比基准值小的都在左边序列(一般是无序的),
 * 比基准值大的都在右边(一般是无序的)。
 * 一般选择序列的第一个元素。
 * 一次循环:从后往前比较,用基准值和最后一个值比较,如果比基准值小的交换位置,如果没有,
 * 继续比较下一个,直到找到第一个比基准值小的值才交换。找到这个值之后,又从前往后开始比较,
 * 如果有比基准值大的,交换位置,如果没有继续比较下一个,直到找到第一个比基准值大的值才交换。
 * 直到从前往后的比较索引>从后往前比较的索引,结束第一次循环,此时,对于基准值来说,左右两边就是有序的了。:
 * <p>
 * https://blog.csdn.net/fwcN1/article/details/80411938
 * 这篇博客对快排讲的挺清楚
 *
 * @author cyg
 * @date 2019/3/6 上午10:50
 **/
public class FastSort {

    public int[] fastSoft(int[] a, int low, int high) {
        //左哨兵,从左往右检测比基准值大的值
        int start = low;
        //右哨兵,从右往左检测比基准值小的值
        int end = high;
        //基准值,取最左边的值
        int key = a[low];
        while (end > start) {
            //从后往前进行比较
            while (end > start && a[end] >= key) {
                end--;
            }
            //交换基准值与比基准值小的值的位置
            if (a[end] < key) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while (end > start && a[start] <= key) {
                start++;
            }
            //交换基准值与比基准值大的值的位置
            if (a[start] > key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            if (start > low) {
                //左边序列。第一个索引位置到关键值索引-1
                fastSoft(a, low, start - 1);
            }
            if (end < high) {
                //右边序列。从关键值索引+1 到最后一个
                fastSoft(a, end + 1, high);
            }
        }
        return a;
    }

    public static void main(String[] args) {
        FastSort fastSort = new FastSort();
        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }
        arr = fastSort.fastSoft(arr, 0, arr.length - 1);
        for (int a : arr) {
            System.out.print(a + " , ");
        }
    }
}
