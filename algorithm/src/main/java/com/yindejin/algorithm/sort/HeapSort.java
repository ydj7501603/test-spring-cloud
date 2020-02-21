package com.yindejin.algorithm.sort;

/**
 * @author: YDJ
 * @Date: 2020/2/20
 * @Description:
 */
public class HeapSort {


    public static void heapSort(int[] nums) {
        //构建大顶堆，从第一个非叶子节点开始，为什么i = num.length/2 -1 ?
        for (int i = nums.length/2 - 1; i >= 0 ; i--) {
            adjustHeap(nums, i, nums.length);
        }

        for (int j = nums.length - 1; j >0; j--) {
            swap(nums, 0, j);
            adjustHeap(nums, 0, j);
        }
    }

    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void adjustHeap(int[] nums, int i, int len){
        int temp = nums[i];
        //堆有一个特点，比如节点i，它的左节点位置 2*i + 1，右节点位置 2*i + 2，for循环从左节点开始
        for (int j = i*2 + 1; j < len; j = j*2 +1) {
            //判断左右节点，谁大谁小
            if (j+1 < len && nums[j] < nums[j+1]){
                j++;
            }
            //如果大于父节点，和父节点交换
            if (nums[j] > temp) {
                nums[i] = nums[j];
                i = j;
            }else {
                //左右节点都比当前父节点小，则不动
                break;
            }
        }
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5,11,2,6,23,112};
        heapSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
