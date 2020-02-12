package com.yindejin.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: YDJ
 * @Date: 2020/2/5
 * @Description:
 */
public class FindKthLargest {


    /**
     * 查找第K大的元素，创建小顶堆。保证堆中只有K，那么堆顶就是我们要的
     * @param nums
     * @param k
     * @return
     */
    private int findKthLargest(int[] nums, int k){

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k){
                heap.poll();
            }
        }

        return heap.poll();
    }
}
