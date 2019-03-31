package com.cyg.suanfa.algorithm;

import java.util.ArrayList;

/**
 * 和为S的连续正数序列:
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * @author cyg
 * @date 2019/3/31 上午11:54
 **/
public class FindContinuousSequence {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        for (double i = sum / 2 + 1; i >= 2; i--) {
            ArrayList arrayList = new ArrayList();
            double m = (sum / i);
            //判断这组连续整数是奇数还是偶数
            if ((int) m == m) {
                //这组连续整数是奇数个时,中间值左右两边各还有(i - 1) / 2)个数
                for (int j = (int) (m - (i - 1) / 2); j <= (int) (m + (i - 1) / 2); j++) {
                    if (j <= 0) {
                        break;
                    }
                    arrayList.add(j);
                }
            } else {
                //这组连续整数是偶数个,中间值取得是中间两个值左边的那个,左边有(i / 2 - 1)个数,右边有(i / 2 + 1)个数
                for (int j = (int) (m - (i / 2 - 1)); j < (int) (m + (i / 2 + 1)); j++) {
                    if (j <= 0) {
                        break;
                    }
                    arrayList.add(j);
                }
            }
            int count = 0;
            //求和
            for (Object k : arrayList) {
                count += (int) k;
            }
            //判断和是否正确
            if (count == sum) {
                arrayLists.add(arrayList);
            }
        }
        return arrayLists;
    }

    public static void main(String[] args) {
        FindContinuousSequence findContinuousSequence = new FindContinuousSequence();
        System.out.println(findContinuousSequence.FindContinuousSequence(15));
    }
}
