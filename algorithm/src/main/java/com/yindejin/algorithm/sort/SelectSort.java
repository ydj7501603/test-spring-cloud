package com.yindejin.algorithm.sort;

/** 选择排序
 * @author: YDJ
 * @Date: 2020/2/19
 * @Description: 选择排序的核心就是比较了之后，只记录哪个Index谁大（小），最终只进行一次交换
 */
public class SelectSort {

    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,11,2,6,23,112};
        selectSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
