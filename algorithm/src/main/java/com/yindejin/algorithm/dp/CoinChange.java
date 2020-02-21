package com.yindejin.algorithm.dp;

/**
 *  硬币找零
 * @author: YDJ
 * @Date: 2020/2/19
 * @Description:
 * https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-suan-fa-si-xiang-by-hikes/
 */
public class CoinChange {


    public int coinChange(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int cost = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    if (dp[i - coins[j]] != Integer.MAX_VALUE) {
                        cost = Math.min(cost, dp[i - coins[j]] + 1);
                    }
                }
            }
            dp[i] = cost;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
