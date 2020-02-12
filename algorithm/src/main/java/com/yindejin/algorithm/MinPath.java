package com.yindejin.algorithm;

/**
 * @author: YDJ
 * @Date: 2020/1/23
 * @Description:
 */
public class MinPath {

    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                }
                else if(j == grid[0].length - 1 && i != grid.length - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                }
                else if(j != grid[0].length - 1 && i != grid.length - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
                else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }


    public static int minPathSum2(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[j] = grid[i][j] +  dp[j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + dp[j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                else
                    dp[j] = grid[i][j];
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {
        int[][] arr = {{1,3,5,2,4}, {13,4,22,33,5},{13,4,22,33,5},{13,4,22,33,5}};
//        System.out.println(minPathSum(arr));

//        System.out.println(minPathSum2(arr));
        int[][] arr1 = new int[5][6];
        arr1[0] = new int[]{1,2,3,4,6,6,7};
        System.out.println(arr1.length + "," +arr1[0].length);
    }

}
