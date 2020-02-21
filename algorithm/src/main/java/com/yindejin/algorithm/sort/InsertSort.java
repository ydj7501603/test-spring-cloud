package com.yindejin.algorithm.sort;

/** 插入排序
 * @author: YDJ
 * @Date: 2020/2/19
 * @Description: 核心思想，我们认为前面的已经排好序了，拿后面的数和前面的数挨个比较，大（小）就前后交换
 * https://www.jianshu.com/p/d2cf77f78b3e
 */
public class InsertSort {


    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i -1; j>=0 && nums[j] > nums[j+1]; j--){
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,11,2,6,23,112};
        insertSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
