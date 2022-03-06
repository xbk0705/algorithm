package com.xiabaike.algo.leetcode.offer.day10;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * 输入：nums = [1,1,1,1,1], target = 3    输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 */
public class FindTargetSumWays {

    private int count = 0;

    // 回溯
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    private void backtrack(int[] nums, int target, int index, int sum) {
        if (nums.length == index) {
            if (target == sum) {
                count++;
            }
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }

    // 假设所有符号为+的元素和为x，符号为-的元素和的绝对值是y。
    // 我们想要的 S = 正数和 - 负数和 = x - y
    // 而已知x与y的和是数组总和：x + y = sum
    // 可以求出 x = (S + sum) / 2 = target
    // 也就是我们要从nums数组里选出几个数，令其和为target
    // 于是就转化成了求容量为target的01背包问题 => 要装满容量为target的背包，有几种方案
    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int length = nums.length;
        int neg = diff / 2;
        // dp[j]代表的意义：填满容量为j的背包，有dp[j]种方法
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int i = 0; i < length; i++) {
            for (int j = neg; j >= nums[i]; j--) {
                // 当前填满容量为j的包的方法数 = 之前填满容量为j的包的方法数 + 之前填满容量为(j - num)的包的方法数
                // 也就是当前数num的加入，可以把之前和为j - num的方法数加入进来。
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[neg];
    }
}
