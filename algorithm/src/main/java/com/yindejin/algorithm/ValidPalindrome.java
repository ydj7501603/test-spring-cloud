package com.yindejin.algorithm;

/**
 * @author: YDJ
 * @Date: 2020/2/5
 * @Description:
 */
public class ValidPalindrome {


    /**
     * 这个解法会超时，具体的解法，看leetcode
     * @param s
     * @return
     */
    public boolean validPalindrome(String s){
        if (null == s){
            return false;
        }
        char[] chars = s.toCharArray();
        int i=0, j = chars.length -1;
        return checkPalindrome(chars, i, j, 1);
    }

    private boolean checkPalindrome(char[] chars, int i, int j, int status){
        boolean result = true;
        while (i < j){
            if (chars[i] == chars[j]){
                i++;
                j--;
            }else {
                if (status == 1){
                    return checkPalindrome(chars, i++, j, 0) || checkPalindrome(chars, i, j--, 0);
                }
                result = false;
            }
        }
        return result;
    }
}
