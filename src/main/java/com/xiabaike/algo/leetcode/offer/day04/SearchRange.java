package com.xiabaike.algo.leetcode.offer.day04;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8  输出：[3,4]
 * 输入：nums = [5,7,7,8,8,10], target = 6  输出：[-1,-1]
 */
public class SearchRange {

    // 采用二分搜索法找到目标值的一个位置
    // 基于此位置，向前查询最前面的位置，前后查询最后面的位置
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (index == -1) {
            return new int[]{-1, -1};
        }
        int[] arr = new int[2];
        int start = index;
        while (start > 0 && nums[start - 1] == target) {
            start--;
        }
        arr[0] = start;
        int end = index;
        while (end < length - 1 && nums[end + 1] == target) {
            end++;
        }
        arr[1] = end;
        return arr;
    }

    public int[] searchRange2(int[] nums, int target) {
        int length = nums.length;
        if (length == 0 || nums[0] > target || nums[length - 1] < target) {
            return new int[]{-1, -1};
        }

        int left = leftBinary(nums, target);
        int right = rightBinary(nums, target);
        return new int[] {left, right};
    }

    private static int leftBinary(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                // 继续向左查找
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    private static int rightBinary(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                // 继续向右查找
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }
}
