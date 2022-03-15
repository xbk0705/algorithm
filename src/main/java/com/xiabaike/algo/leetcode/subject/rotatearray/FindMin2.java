package com.xiabaike.algo.leetcode.subject.rotatearray;

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
 * 例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * 输入：nums = [1,3,5]  输出：1
 * 输入：nums = [2,2,2,0,1]  输出：0
 */
public class FindMin2 {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                // 说明 nums[mid] 是最小值右侧的元素，因此我们可以忽略二分查找区间的右半部分。
                right = mid;
            } else if (nums[mid] > nums[right]) {
                // 说明 nums[mid] 是最小值左侧的元素，因此我们可以忽略二分查找区间的左半部分。
                left = mid + 1;
            } else {
                // 由于重复元素的存在，我们并不能确定 nums[mid] 究竟在最小值的左侧还是右侧，因此我们不能莽撞地忽略某一部分的元素。
                // 我们唯一可以知道的是，由于它们的值相同，所以无论 nums[high] 是不是最小值，都有一个它的「替代品」nums[pivot]，
                // 因此我们可以忽略二分查找区间的右端点。
                right--;
            }
        }
        // 当二分查找结束时，我们就得到了最小值所在的位置。
        return nums[left];
    }

}
