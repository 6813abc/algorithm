package com.cyg.suanfa.algorithm;

import java.util.Arrays;

/**
 * 二叉搜索树的后序遍历序列:
 * 输入一个整数数组，
 * 判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * @author cyg
 * @date 2019/3/20 下午4:33
 **/
public class VerifySquenceOfBST {

    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence.length == 1) {
            return true;
        }
        if (sequence.length == 0) {
            return false;
        }
        int root = sequence[sequence.length - 1];
        int index = 0;
        for (int i = 0; i < sequence.length - 1; i++) {
            System.out.println(sequence[i]);
            if (sequence[i] > root) {
                index = i - 1;
            }
            if (i > index && sequence[i] < root && index != 0) {
                return false;
            }
        }
        if (index <= 0) {
            return verifySquenceOfBST(Arrays.copyOfRange(sequence, 0, sequence.length - 1));
        } else {
            return verifySquenceOfBST(Arrays.copyOfRange(sequence, 0, sequence.length - 1))
                    && verifySquenceOfBST(Arrays.copyOfRange(sequence, index, sequence.length - 1));
        }
    }

    public static void main(String[] args) {
        VerifySquenceOfBST verifySquenceOfBST = new VerifySquenceOfBST();
        int[] array = {4, 8, 6, 12, 16, 14, 10};
        System.out.println(verifySquenceOfBST.verifySquenceOfBST(array));
    }
}
