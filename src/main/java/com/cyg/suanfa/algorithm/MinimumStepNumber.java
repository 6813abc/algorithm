package com.cyg.suanfa.algorithm;

/**
 * 最小步数移动到数组末尾:
 * 给定一个数组，里面全是正整数。数字大小表示这一步最多可以向后移动几个节点。
 * 总是从数组第一个元素开始移动。问如何移动，可以以最少步数移动到最后一个节点。
 * 例如：[3,4,2,1,3,1]初始状态指向3表示下一步可以移动1格，或者2格，或者3格。
 * 最优的方式是指向3的时候移动一步，第二次选择移动4步，一共只需要两步即可移动到数组尾。
 *
 * @author cyg
 * @date 2019/4/1 下午2:28
 **/
public class MinimumStepNumber {

    //维持两个指针，一个表示当前最远可以跳到哪一步，
    // 一个表示下一步最远可以跳到哪一步。遍历原数组同时更新指针。
    public int minimumStepNumber(int[] a) {
        int cur = 0;
        int far = a[0];
        int step = 0;
        while (cur < a.length) {
            if (far >= a.length - 1) {
                return step + 1;
            }
            int nextStep = cur;
            int temp = far;
            while (cur <= temp) {
                if (a[cur] + cur > far) {
                    nextStep = cur;
                    far = a[cur] + cur;
                }
                cur++;
            }
            step++;
            cur = nextStep;
        }
        return -1;
    }

    public int minimumStepNumber1(int[] nums) {
        //记录步数
        int step = 0;
        //记录本次移动了几步
        int temp = 0;
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] >= nums.length - 1) {
            return step + 1;
        }
        for (int i = 0; i < nums.length; ) {
            //记录从当前位置经过两次跳跃能达到的最大距离
            int longestDistance = 0;
            for (int j = 1; j <= nums[i]; j++) {
                //判断接下来一次跳跃能否到达最后一个点,能的话就返回 step+1
                if (i + j >= nums.length - 1) {
                    return step + 1;
                }
                //判断接下来两次跳跃能否到达最后一个点,能的话就返回 step+2
                if (i + j + nums[i + j] >= nums.length - 1) {
                    return step + 2;
                }
                if (j + nums[i + j] > longestDistance) {
                    longestDistance = j + nums[i + j];
                    temp = j;
                }
            }
            i = i + temp;
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumStepNumber minimumStepNumber = new MinimumStepNumber();
        int[] a = {0};
        int[] b = {3, 7, 5, 4, 2};
        int[] c = {3, 7, 5, 4, 2, 6, 4};
        System.out.println(minimumStepNumber.minimumStepNumber(a) + "," + minimumStepNumber.minimumStepNumber1(a));
        System.out.println(minimumStepNumber.minimumStepNumber(b) + "," + minimumStepNumber.minimumStepNumber1(b));
        System.out.println(minimumStepNumber.minimumStepNumber(c) + "," + minimumStepNumber.minimumStepNumber1(c));
    }
}
