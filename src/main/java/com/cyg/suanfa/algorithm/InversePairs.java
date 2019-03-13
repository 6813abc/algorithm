package com.cyg.suanfa.algorithm;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 *
 * @author cyg
 * @date 2019/3/13 下午6:51
 **/
public class InversePairs {

    /**
     * 常规思维
     **/
    public int InversePairs(int[] array) {
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    num++;
                }
            }
        }
        return num % 1000000007;
    }

    /**
     * 不一般的思维(主体思想为归并排序的改编版)
     * 先把数组分隔成子数组，统计出子数组内部的逆序对的数目，
     * 然后再统计出两个相邻子数组之间的逆序对的数目。
     **/
    private int count = 0;

    public int InversePairs1(int[] a) {
        if (a == null || a.length == 0) {
            return -1;
        }
        mergeSort(a, 0, a.length - 1);
        return count;
    }

    public void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    public void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int t = right - left;
        int l = mid;
        int r = right;
        while (l >= left && r >= mid + 1) {
            if (a[l] > a[r]) {
                count += (r - mid);
                tmp[t--] = a[l--];
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
            } else {
                tmp[t--] = a[r--];
            }
        }
        while (l >= left) {
            tmp[t--] = a[l--];
        }
        while (r >= mid + 1) {
            tmp[t--] = a[r--];
        }
        for (int i = 0; i <= right - left; i++) {
            a[left + i] = tmp[i];
        }
    }
}
