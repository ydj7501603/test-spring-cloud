package com.yindejin.algorithm.sort;

/** 冒泡排序
 * @author: YDJ
 * @Date: 2020/2/19
 * @Description:
 */
public class BubbleSort {


    public static void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {5,11,2,6,23,112};
        bubbleSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
