package com.xiabaike.algo.leetcode.simple.dynamic;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]  输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
public class MaxSubArray {

    // 只需要判断前一次sum是大于0还是小于0。
    // 如果前一次sum大于0，就继续累加，sum=前一次sum+num[i]。
    // 如果前一次sum小于0，我们直接把前面的舍弃，也就是说重新开始计算，否则会越加越小的，直接让sum=num[i]
    // sum = num[i] + max(前一次sum, 0);
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = sum;
        for (int i = 1; i < nums.length; i++) {
            // 加和
            sum = Math.max(sum, 0) + nums[i];
            // 取最大值
            max = Math.max(max, sum);
        }
        return max;
    }

}
