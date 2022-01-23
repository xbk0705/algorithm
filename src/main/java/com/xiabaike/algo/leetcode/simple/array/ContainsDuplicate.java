package com.xiabaike.algo.leetcode.simple.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * 输入：nums = [1,2,3,1]  输出：true
 * 输入：nums = [1,2,3,4]  输出：false
 *
 * @author xiabaike
 * Created on 2022-01-21
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 1) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate duplicate = new ContainsDuplicate();
        int[] nums = {1,2,3,4,4};
        boolean result = duplicate.containsDuplicate(nums);
        System.out.println(result);
    }

}
