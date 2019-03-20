package com.cyg.suanfa.algorithm;

import java.util.ArrayList;

/**
 * 和为S的两个数字:
 * 输入一个递增排序的数组和一个数字S，
 * 在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * @author cyg
 * @date 2019/3/20 下午3:21
 **/
public class FindNumbersWithSum {

    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] == sum) {
                arrayList.add(array[left]);
                arrayList.add(array[right]);
                break;
            } else if (array[left] + array[right] < sum) {
                left++;
            } else {
                right--;
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        FindNumbersWithSum findNumbersWithSum = new FindNumbersWithSum();
        System.out.println(findNumbersWithSum.findNumbersWithSum(array, 5));
    }
}
