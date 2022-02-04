package com.xiabaike.algo.leetcode.offer.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 *
 * 输入：nums = [-1,0,1,2,-1,-4]  输出：[[-1,-1,2],[-1,0,1]]
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = nums.length - 1;
            int target = -nums[first];
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(nums[first]);
                    list1.add(nums[second]);
                    list1.add(nums[third]);
                    list.add(list1);
                }
            }
        }

        return list;
    }



}
