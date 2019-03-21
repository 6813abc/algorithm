package com.cyg.suanfa.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符流中第一个不重复的字符 :
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * @author cyg
 * @date 2019/3/21 下午6:46
 **/
public class FirstAppearingOnce {

    int[] count = new int[128];
    List<Character> list = new ArrayList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        count[ch]++;
        if (count[ch] == 1) {
            list.add(ch);
        } else {
            list.remove((Character) ch);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (list.size() == 0) {
            return '#';
        } else {
            return list.get(0);
        }
    }
}
