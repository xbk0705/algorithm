package com.xiabaike.sensorsdata.algo.mianshi75;

public class MoveZeroes {

    public static void main(String[] args) {

    }

    /**
     * 输入: nums = [0,1,0,3,12] 1 0 0 3 12  1 3 0 0 12
     * 输出: [1,3,12,0,0]
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        // 非零个数
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        // 非零个数
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
    }

}
