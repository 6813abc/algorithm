package com.cyg.suanfa.algorithm;

/**
 * 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 * @author cyg
 * @date 2019/3/25 上午10:54
 **/
public class Multiply {

    public int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        if (A.length != 0) {
            B[0] = 1;
            // 计算前i - 1个元素的乘积
            for (int i = 1; i < A.length; i++)
                B[i] = B[i - 1] * A[i - 1];
            int temp = 1;
            // 计算后N - i个元素的乘积并连接
            for (int i = len - 2; i >= 0; i--) {
                temp *= A[i + 1];
                B[i] *= temp;
            }
        }
        return B;
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        int[] A = {2, 4, 3, 5};
        int[] B = multiply.multiply(A);
        for (int i = 0; i < B.length; i++) {
            System.out.println(B[i]);
        }
    }
}
