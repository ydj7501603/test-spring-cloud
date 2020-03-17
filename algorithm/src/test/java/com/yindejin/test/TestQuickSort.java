package com.yindejin.test;

/**
 * @author: YDJ
 * @Date: 2020/3/10
 * @Description:
 */
public class TestQuickSort {

    public void quickSort(int[] nums, int left, int right){
        if (left > right){
            return;
        }
        int partition = partition(nums, left, right);
        quickSort(nums, left, partition-1);
        quickSort(nums, partition+1, right);
    }


    private int partition(int[] nums, int left, int right){
        if (left > right) {
            return -1;
        }
        int i = left, j = right;
        int index = nums[left];
        while (i < j){
            while (nums[j] >= index && i < j){
                j--;
            }
            while (nums[i] <= index && i < j){
                i++;
            }

            if (i<j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[left] = nums[i];
        nums[i] = index;
        return i;
    }

    public static void main(String[] args) {
        TestQuickSort testQuickSort = new TestQuickSort();
        int[] nums = {12,3,5,34,534,123,876,7,56,98};
        testQuickSort.quickSort(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.println(num);
        }

    }


}
