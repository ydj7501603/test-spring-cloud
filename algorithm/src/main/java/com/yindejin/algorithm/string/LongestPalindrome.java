package com.yindejin.algorithm.string;

import java.util.HashMap;

/** 最长的回文字符串
 * @author: YDJ
 * @Date: 2020/2/15
 * @Description:
 */
public class LongestPalindrome {

    public int longestPalindrome(String s){
        if (null == s) {
            return 0;
        }
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0).intValue() + 1);
        }
        int doubleStrNum = 0;
        boolean singeNum = false;
        for (Integer o : map.values()) {

            //为什么要/2 * 2，是为了处理奇数的情况，5/2 = 2 * 2 =4。我们只取4，下一步处理奇数
            if (o >= 2){
                doubleStrNum += (o.intValue()/2)*2;
            }
            //奇数个字母，只计算一次字母的长度，比如一个5，一个3，只需要一个
            if (o%2 != 0 && !singeNum){
                doubleStrNum++;
                singeNum = true;
            }
        }
        return doubleStrNum;
    }

}
