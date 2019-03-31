package com.cyg.suanfa.algorithm;

/**
 * 把字符串转换成整数:
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 *
 * @author cyg
 * @date 2019/3/31 下午7:07
 **/
public class StrToInt {

    public int StrToInt(String str) {
        //判断输入是否合法
        if (str == null || str.equals("")) {
            return 0;
        }
        // symbol=0,说明该数为正数;symbol=1，该数为负数;start用来区分第一位是否为符号位
        int symbol = 0;
        int start = 0;
        char[] chars = str.toCharArray();
        if (chars[0] == '+') {
            start = 1;
        } else if (chars[0] == '-') {
            start = 1;
            symbol = 1;
        }
        int result = 0;
        for (int i = start; i < chars.length; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                return 0;
            }
            int sum = result * 10 + (chars[i] - '0');


            if ((sum - (chars[i] - '0')) / 10 != result) {
                return 0;
            }

            result = result * 10 + (chars[i] - '0');
        }
        // 注意：java中-1的n次方不能用：(-1)^n .'^'异或运算
        // 注意，当value=-2147483648时，value=-value
        result = (int) Math.pow(-1, symbol) * result;
        return result;
    }

    public static void main(String[] args) {
        StrToInt strToInt = new StrToInt();
        System.out.println(strToInt.StrToInt("1200000000"));
    }
}
