package com.xiabaike.algo.secondtime.simple2.array;

import java.util.Arrays;

/**
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3  输出: [5,6,7,1,2,3,4]
 */
public class Rotate {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        }
        k = k % nums.length;
        int[] new_nums = new int[nums.length];
        int index = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            new_nums[index++] = nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            new_nums[index++] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = new_nums[i];
        }
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[] nums = {1,2};
        int k = 3;
        rotate.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

}
