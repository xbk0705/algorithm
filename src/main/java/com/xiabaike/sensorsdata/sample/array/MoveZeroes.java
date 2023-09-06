package com.xiabaike.sensorsdata.sample.array;

public class MoveZeroes {

    // 输入: nums = [0,1,0,3,12]
    // 输出: [1,3,12,0,0]
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        int zeroNum = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                zeroNum++;
            } else if (zeroNum != 0) {
                // 把当前数字放到最前面那个0的位置，然后再把当前位置设为0
                nums[j - zeroNum] = nums[j];
                nums[j] = 0;
            }
        }
    }

    public void moveZeroes3(int[] nums) {
        int notZeroNum = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int tmp = nums[j];
                nums[j] = nums[notZeroNum];
                nums[notZeroNum] = tmp;

                notZeroNum++;
            }
        }
    }

}
