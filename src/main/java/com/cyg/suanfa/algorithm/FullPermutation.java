package com.cyg.suanfa.algorithm;

import java.util.*;

/**
 * 实现算法：求全排列。
 * 输入：一个字符串
 * 输出：字符串的全排列
 *
 * @author cyg
 * @date 2019/3/6 下午8:19
 **/
public class FullPermutation {


    public ArrayList<String> Permutation(String str) {

        ArrayList<String> list = new ArrayList<String>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, list);
            Collections.sort(list);
        }

        return list;
    }
    
    private void PermutationHelper(char[] chars, int i, ArrayList<String> list) {
        if (i == chars.length - 1) {
            list.add(String.valueOf(chars));
        } else {
            Set<Character> charSet = new HashSet<Character>();
            for (int j = i; j < chars.length; ++j) {
                if (j == i || !charSet.contains(chars[j])) {
                    charSet.add(chars[j]);
                    swap(chars, i, j);
                    PermutationHelper(chars, i + 1, list);
                    swap(chars, j, i);
                }
            }
        }
    }

    private void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
        FullPermutation fullPermutation = new FullPermutation();
        System.out.println(fullPermutation.Permutation("123"));
    }
}
