package com.cyg.suanfa.algorithm;

/**
 * 数字在排序数组中出现的次数:
 * 统计一个数字在排序数组中出现的次数。
 *
 * @author cyg
 * @date 2019/3/31 上午11:32
 **/
public class GetNumberOfK {

    public int GetNumberOfK(int[] array, int k) {
        if (array.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                count++;
                //因为是有序,所以值从相等变为不等的话就可以结束循环了
                if (i != array.length - 1 && array[i + 1] != k) {
                    break;
                }
            }
        }
        return count;
    }
}
