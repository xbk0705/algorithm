package com.xiabaike.algo.leetcode.simple.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        int[] nums = new int[nums1.length];
        int index = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    nums[index++] = nums1[i];
                    i++;
                } else if (index > 0) {
                    return Arrays.copyOfRange(nums, 0, index);
                }
            }
        }
        return Arrays.copyOfRange(nums, 0, index);
    }

    public int[] intersect2(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] nums = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            if (map.containsKey(num)) {
                int count = map.get(num);
                if (count > 0) {
                    nums[index] = num;
                    index++;
                    map.put(num, count - 1);
                }
            }
        }
        return Arrays.copyOfRange(nums, 0 ,index);
    }

    public static void main(String[] args) {
        Intersect intersect = new Intersect();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

//        int[] nums1 = {1,2,2,1};
//        int[] nums2 = {2,2};
        int[] result = intersect.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));

    }

}
