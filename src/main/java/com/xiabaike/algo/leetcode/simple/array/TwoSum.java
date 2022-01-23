package com.xiabaike.algo.leetcode.simple.array;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 输入：nums = [2,7,11,15], target = 9  输出：[0,1]  解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 输入：nums = [3,2,4], target = 6  输出：[1,2]
 * 输入：nums = [3,3], target = 6   输出：[0,1]
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
//        int[] nums = {2,7,11,15};
//        int target = 9;

//        int[] nums = {3,2,4};
//        int target = 6;

        int[] nums = {3,3};
        int target = 6;
        int[] result = twoSum.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }


}
