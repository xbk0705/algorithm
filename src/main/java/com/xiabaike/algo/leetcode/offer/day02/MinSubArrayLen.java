package com.xiabaike.algo.leetcode.offer.day02;

import java.util.Arrays;

/**
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]  输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 输入：target = 4, nums = [1,4,4]   输出：1
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            int count = 1;
            if (sum >= target) {
                min = min == 0 ? count : Math.min(min, count);
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                count++;
                if (sum >= target) {
                    min = min == 0 ? count : Math.min(min, count);
                    break;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        int min = minSubArrayLen.minSubArrayLen(213, nums);
        System.out.println(min);
    }

}
