package com.xiabaike.algo.leetcode.offer.day07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 输入：[3,2,3]  输出：3
 * 输入：[2,2,1,1,1,2,2]   输出：2
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        int value = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (max < count) {
                max = count;
                value = entry.getKey();
            }
        }
        return value;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
    // 且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
    // 因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
    // 这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
    public int majorityElement3(int[] nums) {
        int count = 0;
        int majority = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
            }
            if (majority == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }

}
