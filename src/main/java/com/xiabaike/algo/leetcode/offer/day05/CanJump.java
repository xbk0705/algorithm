package com.xiabaike.algo.leetcode.offer.day05;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 输入：nums = [2,3,1,1,4]  输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 输入：nums = [3,2,1,0,4]  输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        int length = nums.length;
        int tmp = length - 1;
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] >= tmp - i) {
                tmp = i;
            }
        }
        return tmp == 0;
    }

    // 贪心算法
    public boolean canJump2(int[] nums) {
        int length = nums.length;
        // 最远可以到达的位置
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (i <= max) {
                max = Math.max(max, nums[i] + i);
                if (max >= length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
