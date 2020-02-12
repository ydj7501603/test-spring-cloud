package com.yindejin.algorithm.sort;

/** 快排
 * @author: YDJ
 * @Date: 2020/2/12
 * @Description:
 */
public class QuickSort {


    public void quickSort(int[] num, int left, int right) {
        if (left > right) {
            return;
        }

        int partition = partition(num, left, right);

        quickSort(num, left, partition - 1);

        quickSort(num, partition+1, right);
    }


    public int partition(int[] num, int left, int right){
        if (left <= right) {
            int temp = num[left];
            int i = left, j = right;
            while (i < j) {
                while (num[j] >= temp && j > i){
                    j--;
                }
                while (num[i] <= temp && j > i){
                    i++;
                }
                if (i<j) {
                    int tmp = num[i];
                    num[i] = num[j];
                    num[j] = tmp;
                }
            }
            num[left] = num[i];
            num[i] = temp;

            return  i;
        }
        return -1;

    }


    public static void main(String[] args) {
        int[] nums = {5,3,1,6,2};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.println(num);
        }
    }

}
