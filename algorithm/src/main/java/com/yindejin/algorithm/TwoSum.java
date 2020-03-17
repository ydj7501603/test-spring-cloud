package com.yindejin.algorithm;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: YDJ
 * @Date: 2020/3/10
 * @Description:
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) throws FileNotFoundException {
        if (null == nums){
            return new int[]{};
        }
        HashMap<Integer, Integer> map = new HashMap();
        for(int i =0, len = nums.length; i < len; i++){
            map.put(nums[i], i);
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        LinkedHashMap linkedHashMap = null;
        return new int[]{};


    }
}
