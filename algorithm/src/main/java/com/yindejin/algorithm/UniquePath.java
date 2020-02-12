package com.yindejin.algorithm;

import java.util.Arrays;

/**
 * @author: YDJ
 * @Date: 2020/1/23
 * @Description:
 */
public class UniquePath {
    private static int uniquepath(int m, int n){
        int[] arr = new int[m];
        Arrays.fill(arr, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                arr[j] = arr[j] + arr[j - 1];
            }
        }
        return arr[m - 1];
    }

    public static void main(String[] args) {
        uniquepath(8, 3);
    }
}
