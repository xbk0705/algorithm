package com.xiabaike.algo.leetcode.simple.array;

import java.util.Arrays;

/**
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
 * 可以不考虑输出结果的顺序。
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]  输出：[2,2]
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]  输出：[4,9]
 */
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int length;
        if (nums1.length > nums2.length) {
            length = nums2.length;
        } else {
            length = nums1.length;
        }
        int[] result = new int[length];

        int left = 0;
        int right = 0;
        int index = 0;
        while (left < nums1.length && right < nums2.length) {
            if (nums1[left] == nums2[right]) {
                result[index] = nums1[left];
                index++;
                left++;
                right++;
            } else if (nums1[left] > nums2[right]) {
                right++;
            } else if (nums1[left] < nums2[right]) {
                left++;
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }

    public static void main(String[] args) {
        Intersect intersect = new Intersect();
//        int[] nums1 = {4,9,5};
//        int[] nums2 = {9,4,9,8,4};

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] result = intersect.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));

    }

}
