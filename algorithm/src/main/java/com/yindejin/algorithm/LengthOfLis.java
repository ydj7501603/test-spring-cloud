package com.yindejin.algorithm;

import java.util.Arrays;

/**
 * @author: YDJ
 * @Date: 2020/1/27
 * @Description:
 */
public class LengthOfLis {

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (i > j) {
                    dp[i] = Math.max(dp[i], dp[j+1]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,3,2,4,6};
        lengthOfLIS(nums);
    }
}
