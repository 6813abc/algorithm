package com.cyg.suanfa.algorithm;

/**
 * 插入排序算法:通过构建有序序列,对于未排序数据,在已排序序列中从后向前扫描,找到相应的位置并插入。
 * 插入排序非常类似于整扑克牌。在开始摸牌时,左手是空的,牌面朝下放在桌上。接着,一次从
 * 桌上摸起一张牌,并将它插入到左手一把牌中的正确位置上。为了找到这张牌的正确位置,要将
 * 它与手中已有的牌从右到左地进行比较。无论什么时候,左手中的牌都是排好序的
 * 如果输入数组已经是排好序的话,插入排序出现最佳情况,其运行时间是输入规模的一个线性函
 * 数。如果输入数组是逆序排列的,将出现最坏情况。平均情况与最坏情况一样,其时间代价是(n2)。
 *
 * @author cyg
 * @date 2019/3/6 下午1:57
 **/
public class InsertSort {


    public int[] soft(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int index = i - 1;

            while (index >= 0 && insertValue < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = insertValue;
        }
        
        return arr;
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] array = {6, 2, 3, 4, 5, 7, 10, 8, 9, 1};
        array = insertSort.soft(array);
        for (int a : array) {
            System.out.print(a + " , ");
        }
    }

}
