package com.yindejin.algorithm;

/** leetcode 283 移动零
 * @author: YDJ
 * @Date: 2020/2/29
 * @Description:
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return;
        }

        int i =0; int j=0;

        while (i < nums.length && j < nums.length) {
            if (nums[i] != 0) {
                i++;
                continue;
            }
            if (nums[j] == 0){
                j++;
                continue;
            }
            if (nums[i] == 0 && nums[j] != 0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j++;
            }
        }

    }
}
