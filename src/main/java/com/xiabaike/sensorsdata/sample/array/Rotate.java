package com.xiabaike.sensorsdata.sample.array;

public class Rotate {

    // 输入: nums = [1,2,3,4,5,6,7], k = 3
    // 输出: [5,6,7,1,2,3,4]
    // 解释:
    // 向右轮转 1 步: [7,1,2,3,4,5,6]
    // 向右轮转 2 步: [6,7,1,2,3,4,5]
    // 向右轮转 3 步: [5,6,7,1,2,3,4]
    public void rotate(int[] nums, int k) {
        k = nums.length % k;
        int[] newNums = new int[nums.length];
        int index = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            newNums[index++] = nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            newNums[index++] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }
    }

    public void rotate2(int[] nums, int k) {
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[(k + i) % nums.length] = newNums[i];
        }
    }

    public void rotate3(int[] nums, int k) {

    }

}
