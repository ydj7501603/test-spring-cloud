package com.yindejin.algorithm;

import java.util.HashSet;

/**
 * @author: YDJ
 * @Date: 2020/1/27
 * @Description:
 */
public class LengthOfLongestSubstring {

    /**
     * 最长不重复字符串，滑动窗口解法，两个指针，一个往前，一个拖后，遇到重复，后面的指针往前，直到不重复,
     * 如果相同则和i-1
     * @param s
     * @return
     */
    private int lengthOfLongestSubstring(String s){
        if (s.length() <= 1){
            return s.length();
        }
        HashSet set = new HashSet();
        int max = 0;
        int n =0 ,m = 0, len = s.length();
        while (n < len && m < len) {
            if (!set.contains(s.charAt(m))){
                set.add(s.charAt(m++));
                max = Math.max(max, m-n);
            }else {
                set.remove(s.charAt(n++));
            }
        }
        return max;
    }


}
