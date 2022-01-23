package com.xiabaike.algo.leetcode.simple.array;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: [0,1,0,3,12]  输出: [1,3,12,0,0]
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[num] = nums[i];
                num++;
            }
        }
        for (int i = num; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {0,1,0,3,12};
        moveZeroes.moveZeroes(nums);
    }

}
