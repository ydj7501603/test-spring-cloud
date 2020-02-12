package com.yindejin.algorithm;

import java.util.*;

/**
 * @author: YDJ
 * @Date: 2020/2/5
 * @Description:
 */
public class TopKFrequent {

    /**
     * 解决思路，堆（优先队列），hashmap记录次数，优先队列生成堆，保留topk，最后返回
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) +1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return countMap.get(o1) - countMap.get(o2);
            }
        });

        for (Integer key : countMap.keySet()) {
            heap.add(key);
            if (heap.size() > k){
                heap.poll();
            }
        }

        List<Integer> topK = new ArrayList<>();
        while (!heap.isEmpty()){
            topK.add(heap.poll());
        }

        return topK;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,1,2,3,1,2,1,1,2,3,4};

        TopKFrequent topKFrequent = new TopKFrequent();
        topKFrequent.topKFrequent(nums, 3);

    }
}
