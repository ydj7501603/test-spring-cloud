package com.yindejin.algorithm.string;

import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

/** leetcode 151 翻转字符串
 * @author: YDJ
 * @Date: 2020/2/29
 * @Description:
 */
public class ReverseWords {


    /**
     * 三步走
     * 1、翻转整个字符串
     * 2、翻转单词
     * 3、去除多余空格
     * @param s
     */
    public String reverseWords(String s){
        char[] arr = s.toCharArray();
        reverse(arr, 0, arr.length-1);
        reverseWords(arr, arr.length);

        return cleanSpace(arr, arr.length);
    }


    public String cleanSpace(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }

    /**
     * 翻转单词
     * @param arr
     * @param len
     */
    public void reverseWords(char[] arr, int len){
        int i =0, j =0;
        while (j < len && i < len ) {
            while (i < j || i< len && arr[i] == ' ') {
                i++;
            }
            //需要保证，j比I 更大
            while (j < i || j< len && arr[j] != ' ') {
                j++;
            }
            reverse(arr, i, j-1);
        }
    }

    /**
     * 翻转函数
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public String reverse(char[] arr, int i, int j) {
        while (i < j){
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++; j--;
        }
        return new String(arr);
    }


    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords("hello world"));

        ThreadLocal threadLocal= null;

        LinkedHashMap linkedHashMap = null;

        ConcurrentHashMap concurrentHashMap = null;
    }

}
