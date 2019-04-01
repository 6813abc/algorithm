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

    public static void main(String[] args) {
        MinimumStepNumber minimumStepNumber = new MinimumStepNumber();
        int[] a = {3, 4, 2, 1, 3, 1};
        System.out.println(minimumStepNumber.minimumStepNumber(a));
    }
}
