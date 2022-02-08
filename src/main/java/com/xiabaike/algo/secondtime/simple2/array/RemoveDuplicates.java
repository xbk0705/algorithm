package com.xiabaike.algo.secondtime.simple2.array;

import java.util.Arrays;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 输入：nums = [1,1,2]  输出：2, nums = [1,2]
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]  输出：5, nums = [0,1,2,3,4]
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        // 左边界，左侧都是不重复的元素
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            // 如果左右指针所对应的值相等，则右指针右移；
            // 如果左右指针所对应的值不相等，则把右指针指向的值向前移动
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
        }
        System.out.println(Arrays.toString(nums));
        return ++left;
    }

    public int removeDuplicates2(int[] nums) {
        // 重复的个数
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                // 相等则count加1
                count++;
            } else {
                // 不相等，则把当前值移动到前面，即当前值下标减去重复的个数
                nums[i - count] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums.length - count;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int result = removeDuplicates.removeDuplicates(nums);
        System.out.println(result);
        System.out.println("==============");
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        result = removeDuplicates.removeDuplicates(nums2);
        System.out.println(result);
    }

}
