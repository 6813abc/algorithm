package com.cyg.suanfa.algorithm;

/**
 * 希尔排序:
 * 基本思想:先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序,待整个序列
 * 中的记录“基本有序”时,再对全体记录进行依次直接插入排序。
 * 操作方法:
 * 1. 选择一个增量序列 t1,t2,...,tk,其中 ti>tj,tk=1;
 * 2. 按增量序列个数 k,对序列进行 k 趟排序;
 * 3. 每趟排序,根据对应的增量 ti,将待排序列分割成若干长度为 m 的子序列,分别对各子表进
 * 行直接插入排序。仅增量因子为 1 时,整个序列作为一个表来处理,表长度即为整个序列的长
 * 度。
 *
 * @author cyg
 * @date 2019/3/6 下午5:14
 **/
public class ShellSort {

    private int[] shellSort(int[] a) {
        int dk = a.length / 2;
        while (dk >= 1) {
            shellinsertsort(a, dk);
            dk = dk / 2;
        }
        return a;
    }

    public void shellinsertsort(int[] a, int dk) {
        for (int i = dk; i < a.length; i++) {
            int insetValue = a[i];
            int index = i - dk;
            if (a[i] < a[index]) {
                a[i] = a[i = dk];
                int j;
                for (j = i - dk; j >= 0 && insetValue < a[j]; j = j - dk) {
                    a[j + dk] = a[j];
                }
                a[j + dk] = insetValue;
            }
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] array = {6, 2, 3, 4, 5, 7, 1, 8, 9, 10};
        array = shellSort.shellSort(array);
        for (int a : array) {
            System.out.print(a + " , ");
        }
    }
}

