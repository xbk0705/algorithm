package com.xiabaike.algo.leetcode.offer.day06;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 *
 * 输入：nums = [100,4,200,1,3,2]  输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]  输出：9
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = Integer.MIN_VALUE;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int longest = num;
                int m = 1;
                while (set.contains(longest + 1)) {
                    longest++;
                    m++;
                }

                max = Math.max(max, m);
            }
        }
        return max;
    }


}
