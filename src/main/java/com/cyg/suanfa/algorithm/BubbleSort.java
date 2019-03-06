package com.cyg.suanfa.algorithm;

/**
 * 冒泡排序算法:
 * (1)比较前后相邻的二个数据,如果前面数据大于后面的数据,就将这二个数据交换。
 * (2)这样对数组的第 0 个数据到 N-1 个数据进行一次遍历后,最大的一个数据就“沉”到数组第N-1 个位置。
 * (3)N=N-1,如果 N 不为 0 就重复前面二步,否则排序完成。
 *
 * @author cyg
 * @date 2019/3/6 上午10:27
 **/
public class BubbleSort {

    public int[] bubbleSort1(int[] array) {
        //小的数往上浮
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int temp;
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public int[] bubbleSort2(int[] array) {
        //大的数往下沉
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                int temp;
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {6, 2, 3, 4, 5, 7, 10, 8, 9, 1};
        array = bubbleSort.bubbleSort1(array);
        for (int a : array) {
            //System.out.print(a + " , ");
        }
        array = bubbleSort.bubbleSort2(array);
        for (int a : array) {
            System.out.print(a + " , ");
        }
    }
}
