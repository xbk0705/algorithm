package com.xiabaike.algo.leetcode;

import java.util.Arrays;

/**
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 *
 * @author xiabaike
 * Created on 2022-01-21
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return;
        }

        int length = nums.length;
        int[] newArr = new int[length];
        for (int i = 0; i < k; i++) {
            newArr[i] = nums[length - i - 1];
        }
        for (int i = 0; i < length - k; i++) {
            newArr[k + i] = nums[i];
        }

        System.out.println(Arrays.toString(newArr));
    }

    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        // 将整个数组进行反转
        reverse(nums, 0, nums.length - 1);
        // 将前部分进行反转
        reverse(nums, 0, k - 1);
        // 将后部分进行反转
        reverse(nums, k, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    // 将数组指定位置进行反转
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {


        RotateArray rotateArray = new RotateArray();

//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        int k = 3;
        int[] nums = {1,2};
        int k = 3;

        rotateArray.rotate2(nums, k);
    }



}
