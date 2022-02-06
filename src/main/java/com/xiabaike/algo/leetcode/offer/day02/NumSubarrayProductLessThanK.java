package com.xiabaike.algo.leetcode.offer.day02;

/**
 * 给定一个正整数数组 nums和整数 k 。
 * 请找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 */
public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int mul = 0;
        while (right < nums.length) {
            mul *= nums[right++];
            while (mul >= k && left < right) {
                mul /= nums[left++];
            }
            count += (right - left) + 1;
        }
        return count;
    }

}
