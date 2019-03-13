package com.cyg.suanfa.algorithm;

/**
 * 题目描述：输入一个整数,输出该数二进制表示中1的个数,其中负数用补码表示.
 *
 * @author cyg
 * @date 2019/3/12 下午7:35
 **/
public class BinarySystem_1 {

    /**
     * 每次将输入的数减一和数本身做&运算,会将这个数最右边的数又一变为0,
     * 在把这个数变为0之前,每循环一次就代表有一个1
     **/
    public int NumberOf1(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }

    /**
     * 将这个数变为char数组,再遍历判断1的个数
     **/
    public int NumberOf1_1(int n) {
        char[] str = Integer.toBinaryString(n).toCharArray();
        int res = 0;
        for (int i = 0; i < str.length; ++i) {
            if (str[i] == '1') {
                ++res;
            }
        }
        return res;
    }
}
