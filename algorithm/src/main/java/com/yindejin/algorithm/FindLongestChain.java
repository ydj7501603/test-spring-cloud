package com.yindejin.algorithm;

import java.util.Arrays;

/**
 * @author: YDJ
 * @Date: 2020/1/27
 * @Description:
 */
public class FindLongestChain {

    private static int findLongestChain(int[][] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i][0] > nums[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i : dp) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
