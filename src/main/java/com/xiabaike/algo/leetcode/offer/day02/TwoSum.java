package com.xiabaike.algo.leetcode.offer.day02;

import java.util.Arrays;

/**
 * 给定一个已按照 非递减顺序排列 的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。
 * numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length
 *
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {

        int[] out = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            while (left <= right) {
                int mid = (right + left) / 2;
                if (numbers[i] + numbers[mid] == target) {
                    out[0] = left + 1;
                    out[1] = right + 1;
                } else if (numbers[i] + numbers[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return out;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int[] out = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                out[0] = left + 1;
                out[1] = right + 1;
                break;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {1,2,3,4,4,9,56,90};
        int[] out = twoSum.twoSum2(nums, 8);
        System.out.println(Arrays.toString(out));
    }

}
