package com.cyg.suanfa.algorithm;

/**
 * 扑克牌顺子:
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,
 * 他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
 * 他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 * <p>
 * 题目解析: 输入五个数,0可以替换为任意数字(最多4个零),判断这五个数能否组成顺子
 *
 * @author cyg
 * @date 2019/3/21 下午7:17
 **/
public class IsContinuous {

    public boolean isContinuous(int[] numbers) {
        //记录最小值,初始值不设置为numbers[0]是为了防止numbers[0]=0
        int min = 13;
        //记录最大值
        int max = 1;
        if (numbers.length == 0) {
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                if (numbers[i] < min) {
                    min = numbers[i];
                }
                if (numbers[i] > max) {
                    max = numbers[i];
                }
                for (int j = i + 1; j < numbers.length; j++) {
                    //如果有非零数重复,那么一定不能构成顺子
                    if (numbers[j] == numbers[i]) {
                        return false;
                    }
                }
            }
        }
        //最大值与最小值的范围必须必须小于5,否则就不能构成顺子
        if ((max - min) >= 5) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 0, 5, 0};
        IsContinuous isContinuous = new IsContinuous();
        System.out.println(isContinuous.isContinuous(array));
    }
}
