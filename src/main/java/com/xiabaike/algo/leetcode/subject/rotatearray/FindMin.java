package com.xiabaike.algo.leetcode.subject.rotatearray;

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 你必须设计一个时间复杂度为O(log n) 的算法解决此问题。
 *
 * 输入：nums = [3,4,5,1,2]   输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 * 输入：nums = [4,5,6,7,0,1,2]    输出：0
 * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
 */
public class FindMin {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // 这里控制条件没取等号，取等号大多是为了在while中直return mid，不取等号就跳出while返回l的值。
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                // 中间数字小于等于右边数字，比如[6,7,1,2,3,4,5]，则右侧是有序上升的，最小值在左侧
                right = mid;
            } else {
                // 中间数字大于右边数字，比如[3,4,5,1,2]，则左侧是有序上升的，最小值在右侧
                left = mid + 1;
            }
        }
        return nums[left];
    }

}
