package com.yindejin.algorithm;

/**
 * @author: YDJ
 * @Date: 2020/1/28
 * @Description:
 */
public class LongestPalindrome {


    /**
     * 反转当前字符串，和原字符串，找出最大公共字符串
     * @param s
     */
    private static void longestPalindrome(String s){
        String reverse = new StringBuffer(s).reverse().toString();
        int[][] dp = new int[s.length()+1][s.length()+1];
        int maxEnd, maxLen = 0;
        String result = "";
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= reverse.length(); j++) {
                if (s.charAt(i -1) == reverse.charAt(j -1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxLen = dp[i][j];
                    maxEnd = i;
                    String v = s.substring(maxEnd - maxLen, maxEnd);
                    if (validPalinadrome(v)){
                        if (v.length() > result.length()){
                            result = v;
                        }
                    }
                }
            }
        }
        System.out.println(result);
        System.out.println(dp[s.length()][s.length()]);

    }


    private static String longestPalindrome2(String s){
        int len = s.length();
        if (len < 2){
            return s;
        }
        int maxLen = 0;
        //如果没有回文字符串，返回第一个字符
        String result = s.substring(0, 1);
        for (int i = 0; i < len; i++) {
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i+1);
            String maxLenStr=  oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen){
                result = maxLenStr;
                maxLen = maxLenStr.length();
            }
        }
        return result;
    }


    private static String centerSpread(String s, int left, int right){
        while (left >=0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)){
                break;
            }else {
                left--;
                right++;
            }
        }
        return s.substring(left, right);
    }


    private static boolean validPalinadrome(String s){
        char[] chars = s.toCharArray();
        int len = chars.length;
        int i = 0, j =len - 1;
        while (i < j){
            if (chars[i] != chars[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        longestPalindrome("abcdbbfcba");
    }
}
