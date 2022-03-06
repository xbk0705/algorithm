package com.xiabaike.algo.leetcode.offer.day10;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 *
 * 输入：nums = [1,1,1], k = 2    输出：2
 * 输入：nums = [1,2,3], k = 3    输出：2
 */
public class SubarraySum {

    // 暴力解法
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // 前缀和+hash表
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        // key:sum,value:count
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

}
