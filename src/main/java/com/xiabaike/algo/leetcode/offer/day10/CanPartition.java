package com.xiabaike.algo.leetcode.offer.day10;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 输入：nums = [1,5,11,5]    输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11]
 *
 * 输入：nums = [1,2,3,5]     输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 */
public class CanPartition {

    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = target; j >= num; j--) {
                if (dp[target]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }

}
