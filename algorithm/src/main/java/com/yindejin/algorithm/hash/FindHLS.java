package com.yindejin.algorithm.hash;

import java.util.HashMap;

/** 寻找最长和谐序列
 * @author: YDJ
 * @Date: 2020/2/29
 * @Description:
 */
public class FindHLS {


    public int findHLS(int[] nums){
        if (null == nums) {
            return 0;
        }

        HashMap<Integer, Integer> countNum = new HashMap();
        for (int num : nums) {
            countNum.put(num, countNum.getOrDefault(num, 0) + 1);
        }

        int maxLen = 0;
        for (Integer key : countNum.keySet()) {
            //如果比当前数更大不存在，则返回0
            if (countNum.containsKey(key + 1)) {
                //直接找当前数和比这个数更大的数，相加
                maxLen = Math.max(maxLen, countNum.get(key) + countNum.getOrDefault(key+1, 0));
            }
        }
        return maxLen;
    }

}
