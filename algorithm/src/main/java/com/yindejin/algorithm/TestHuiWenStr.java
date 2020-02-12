package com.yindejin.algorithm;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author: YDJ
 * @Date: 2020/1/20
 * @Description:
 */
public class TestHuiWenStr {

    static HashSet hashSet = new HashSet();

    static {
        hashSet.addAll(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(hashSet.contains('a'));
        int[] numbers = {1,2,3,4,5};
        System.out.println(Arrays.toString(Arrays.copyOfRange(numbers, 1 , numbers.length)));

    }


    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i =0, len = arr.length-1;
        while (i < len && len >=0 && i >= len){
            if (hashSet.contains(arr[i]) && hashSet.contains(arr[len])){
                char tmp = arr[i];
                arr[i] = arr[len];
                arr[len] = tmp;
            }
            i++;
            len--;
        }
        return new String(arr);
    }
}
