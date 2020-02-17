package com.yindejin.algorithm.string;

import java.util.HashMap;

/** 字符串同构
 * @author: YDJ
 * @Date: 2020/2/15
 * @Description:
 */
public class IsIsomorphic {

    /**
     * leetcode 205 意思是 一个字符只能对应一个字符，不能一对多
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {

        //这里需要反复判断一下，比如s = ab t = cc ，s->t可以通过，但是t->s就不行
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private boolean isIsomorphicHelper(String s, String t){
        HashMap<Character, Character> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            char j = t.charAt(i);
            //可以重复，但是不同不同
            if (map.containsKey(c)){
                if (map.get(c) != j){
                    return false;
                }
            }else {
                map.put(c, j);
            }
        }
        return true;
    }

}
