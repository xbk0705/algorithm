package com.xiabaike.algo.leetcode.subject.rotatearray;

/**
 * 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。
 * 请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
 *
 * 输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 * 输出: 8（元素5在该数组中的索引）
 * 输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 * 输出：-1 （没有找到）
 */
public class Search3 {

    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[left] == target) {
                return left;
            }
            if (arr[mid] == arr[left]) {
                // 此时target可能在[左，mid]中，也可能在[mid + 1, r]中，左 = 左 + 1
                left++;
            } else if (arr[left] < arr[mid]) {
                if (arr[left] < target && target <= arr[mid]) {
                    // 应该有可能重复，所以right = mid
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return -1;
    }

}
