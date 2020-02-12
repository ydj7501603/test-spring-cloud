package com.yindejin.algorithm;

/**
 * @author: YDJ
 * @Date: 2019/12/23
 * @Description:
 */
public class TestBagHuiSu {


    // 回溯算法实现。注意：我把输入的变量都定义成了成员变量。
    private static int maxW = Integer.MIN_VALUE; // 结果放到maxW中
    private static int[] weight = {2, 2, 4, 2, 2};  // 物品重量
    private static int n = 5; // 物品个数
    private static int w = 9; // 背包承受的最大重量

    public static void f(int i, int cw) { // 调用f(0, 0)
        if (cw == w || i == n) { // cw==w表示装满了，i==n表示物品都考察完了
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        f(i + 1, cw); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i]); // 选择装第i个物品
        }
    }


    public static void main(String[] args) {
        f(0, 0);
        System.out.println(maxW);
    }

}
