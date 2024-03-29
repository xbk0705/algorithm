package com.xiabaike.algo.leetcode.offer.day04;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0  输出：4
 */
public class Search {

    // 将数组从中间分开成左右两部分的时候，一定有一部分的数组是有序的
    // 在常规二分查找的时候查看当前 mid 为分割位置分割出来的两个部分 [l, mid] 和 [mid + 1, r] 哪个部分是有序的，
    // 并根据有序的那个部分确定我们该如何改变二分查找的上下界，因为我们能够根据有序的那部分判断出 target 在不在这个部分：
    //   如果 [l, mid - 1] 是有序数组，且 target 的大小满足 [nums[l],nums[mid])，
    //   则我们应该将搜索范围缩小至 [l, mid - 1]，否则在 [mid + 1, r] 中寻找；
    //   如果 [mid, r] 是有序数组，且 target 的大小满足 (nums[mid+1],nums[r]]，
    //   则我们应该将搜索范围缩小至 [mid + 1, r]，否则在 [l, mid - 1] 中寻找；
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 找中间位置
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }
            // 查询有序的一部分
            if (nums[0] <= nums[mid]) {
                // 左侧有序
                // 判断要查找的值
                if (nums[0] <= target && target < nums[mid]) {
                    // 要查找的值在有序的一侧，即左侧
                    right = mid - 1;
                } else {
                    // 要查找的值在无序的一侧，即右侧
                    left = mid + 1;
                }
            } else {
                // 右侧有序
                // 判断要查找的值
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    // 要查找的值在有序的一侧，即右侧
                    left = mid + 1;
                } else {
                    // 要查找的值在无序的一侧，即左侧
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
