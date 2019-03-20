package com.cyg.suanfa.algorithm;

import java.util.ArrayList;

/**
 * 丑数
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * @author cyg
 * @date 2019/3/19 下午9:51
 **/
public class GetUglyNumber_Solution {

    public static int getUglyNumber_Solution(int index) {
        if (index == 0) {
            return 0;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (res.size() < index) {
            int m2 = res.get(i2) * 2;
            int m3 = res.get(i3) * 3;
            int m5 = res.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            res.add(min);
            if (min == m2) i2++;
            if (min == m3) i3++;
            if (min == m5) i5++;
        }
        return res.get(res.size() - 1);
    }

    public static void main(String[] args) {
        GetUglyNumber_Solution getUglyNumber_solution = new GetUglyNumber_Solution();
        System.out.println(getUglyNumber_solution.getUglyNumber_Solution(11));
    }
}
