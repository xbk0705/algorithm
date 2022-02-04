package com.xiabaike.algo.leetcode.offer.day01;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * 输入：nums = [2,2,3,2]  输出：3
 * 输入：nums = [0,1,0,1,0,1,99]  输出：99
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = map.getOrDefault(nums[i], 0);
            map.put(nums[i], num + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

}
