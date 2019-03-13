package com.cyg.suanfa.algorithm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 记录一个面试题: 求一个字符串最长不重复子串
 * 思路: 两层for循环,从第一个数开始,当不重复字串大于len时,定义len的值为当前字串
 *
 * @author cyg
 * @date 2019/3/11 下午2:39
 **/
public class LongestNonRepeatingSubstring {

    public int substring(String str) {
        Set<Character> characters = new HashSet<>();
        int len = 0;
        for (int i = 0; i < str.length(); i++) {
            characters.add(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                //判断是否有重复
                if (!characters.contains(str.charAt(j))) {
                    characters.add(str.charAt(j));
                } else {
                    if (characters.size() > len) {
                        len = characters.size();
                    }
                    //清空set
                    for (Iterator iterator = characters.iterator(); iterator.hasNext(); ) {
                        iterator.next();
                        iterator.remove();
                    }
                    break;
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        LongestNonRepeatingSubstring substring = new LongestNonRepeatingSubstring();
        System.out.println(substring.substring("abcada"));
        System.out.println(substring.substring("pwwkew"));
    }
}
