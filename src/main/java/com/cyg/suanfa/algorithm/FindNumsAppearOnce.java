package com.cyg.suanfa.algorithm;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 找出数组中两个只出现一次的数字:
 * 一个整型数组里除了两个数字之外，
 * 其他的数字都出现了偶数次。
 * 请写程序找出这两个只出现一次的数字
 * num1,num2分别为长度为1的数组。
 * 传出参数将num1[0],num2[0]设置为返回结果
 *
 * @author cyg
 * @date 2019/3/13 下午9:40
 **/
public class FindNumsAppearOnce {

    public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], 2);
            } else {
                map.put(array[i], 1);
            }
        }
        int flag = 0;
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                if (flag == 0) {
                    num1[0] = num;
                    flag++;
                } else {
                    num2[0] = num;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 3, 4};
        int num1[] = new int[1];
        int num2[] = new int[1];
        FindNumsAppearOnce findNumsAppearOnce = new FindNumsAppearOnce();
        findNumsAppearOnce.findNumsAppearOnce(array, num1, num2);
    }
}
