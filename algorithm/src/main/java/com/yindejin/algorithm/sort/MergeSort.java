package com.yindejin.algorithm.sort;

/**
 *  归并排序
 * @author: YDJ
 * @Date: 2020/2/19
 * @Description: 归并的核心在于，merge，判断合并的条件 i<mid && j=mid+1 < right，做完了这步之后，还需要把剩下的合并回去
 * 最后把temp数组拷贝回
 * https://www.cnblogs.com/chengxiao/p/6194356.html
 */
public class MergeSort {

    public void mergeSort(int[] nums) {
        int[] tmp = new int[nums.length];
        sort(nums, 0, nums.length -1, tmp);
    }


    private void sort(int[] nums, int left, int right, int[] temp){
        if (left < right) {
            int mid = left + (right - left)/2;
            sort(nums, left, mid, temp);
            sort(nums, mid+1, right, temp);
            merge(nums, left, right, mid, temp);
        }
    }


    private void merge(int[] nums, int left, int right, int mid, int[] temp){
        int i = left, j = mid + 1, t = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]){
                temp[t++] = nums[i++];
            }else {
                temp[t++] = nums[j++];
            }
        }

        //如果left ,right 长度不等，会执行以下步骤其一
        while (i<= mid) {
            temp[t++] = nums[i++];
        }

        while (j <= right) {
            temp[t++] = nums[j++];
        }

        t = 0;
        while (left <= right){
            nums[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] nums = {5,11,2,6,23,112};
        mergeSort.mergeSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
