package com.cyg.suanfa.algorithm;

/**
 * 左旋转字符串:
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * @author cyg
 * @date 2019/3/21 下午8:00
 **/
public class LeftRotateString {

    public String leftRotateString(String str, int n) {
        StringBuffer s = new StringBuffer();
        String[] array = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (i < n) {
                //在n之前的数提到最后去
                array[str.length() - n + i] = str.substring(i, i + 1);
            } else {
                //在n之后的数提到n之前去
                array[i - n] = str.substring(i, i + 1);
            }
        }
        //拼接字符串数组
        for (int i = 0; i < array.length; i++) {
            s.append(array[i]);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        LeftRotateString leftRotateString = new LeftRotateString();
        System.out.println(leftRotateString.leftRotateString("abcdefg", 2));
    }
}
