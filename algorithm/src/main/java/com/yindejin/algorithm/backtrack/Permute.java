package com.yindejin.algorithm.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  全排列的问题
 * @author: YDJ
 * @Date: 2020/2/13
 * @Description:
 */
public class Permute {

    List<List<Integer>> res = new ArrayList<>();

    /**
     * result = []
     * def backtrack(路径, 选择列表):
     *     if 满足结束条件:
     *         result.add(路径)
     *         return
     *
     *     for 选择 in 选择列表:
     *         做选择
     *         backtrack(路径, 选择列表)
     *         撤销选择
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track) {
        if (nums.length == track.size()){
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //避免重复，判断
            if (track.contains(nums[i])){
                continue;
            }
            //加入
            track.add(nums[i]);
            //递归
            backtrack(nums, track);
            //撤销
            track.removeLast();
        }

    }

}
