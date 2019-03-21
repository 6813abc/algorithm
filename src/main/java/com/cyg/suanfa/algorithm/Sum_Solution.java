package com.cyg.suanfa.algorithm;

/**
 * 求1+2+3+...+n:
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 解析: 短路求值
 *
 * @author cyg
 * @date 2019/3/21 下午7:40
 **/
public class Sum_Solution {

    public int sumSolution(int n) {
        boolean flag = (n > 0) && ((n += sumSolution(n - 1)) > 0);
        return n;
    }

    public static void main(String[] args) {
        Sum_Solution sumSolution = new Sum_Solution();
        System.out.println(sumSolution.sumSolution(5));
    }
}
