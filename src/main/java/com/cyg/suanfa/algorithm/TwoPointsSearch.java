package com.cyg.suanfa.algorithm;

/**
 * 二分查找: 又叫折半查找,要求待查找的序列有序,每次取中间的值与关键值比较,
 * 如果中间的值比关键值大,则在前半部分循环这个查找过程,
 * 如果中间的值比关键值小,则在后半部分循环这个查找过程,
 * 直到查到了为止,否则没有这个值
 *
 * @author cyg
 * @date 2019/3/6 上午10:01
 **/
public class TwoPointsSearch {


    public int biSearch(int[] array, int a) {
        int low = 0;
        int high = array.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] == a) {
                return mid + 1;
            } else if (a < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TwoPointsSearch twoPointsSearch = new TwoPointsSearch();
        System.out.println(twoPointsSearch.biSearch(array, 10));
    }
}
