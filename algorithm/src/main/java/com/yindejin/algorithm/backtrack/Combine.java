package com.yindejin.algorithm.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** 组合问题
 * @author: YDJ
 * @Date: 2020/2/13
 * @Description:
 */
public class Combine {

    List<List<Integer>> res = new ArrayList<>();

    /**
     * 套路和上面的排列是一样的
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        if (n ==0 || k > n ){
            return res;
        }

        LinkedList<Integer> track = new LinkedList();
        backtrack(1, n, k, track);
        return res;
    }


    private void backtrack(int begin, int n, int k, LinkedList<Integer> track) {
        if (track.size() == k){
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = begin; i <= n; i++) {
            track.add(i);
            backtrack(begin+1, n, k, track);
            track.removeLast();
        }

    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        combine.combine(4, 2);
    }

}
