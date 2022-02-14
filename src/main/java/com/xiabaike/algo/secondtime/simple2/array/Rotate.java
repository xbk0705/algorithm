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
        int[] new_nums = new int[nums.length];
        // 把原数组值放到一个临时数组中，
        for (int i = 0; i < nums.length; i++) {
            new_nums[i] = nums[i];
        }
        // 然后在把临时数组的值重新放到原数组，并且往右移动k位
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = new_nums[i];
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
