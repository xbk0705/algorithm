package com.xiabaike.sensorsdata.sample.array;

public class RemoveDuplicates {

    // 输入：nums = [1,1,2]
    //输出：2, nums = [1,2,_]
    // 输入：nums = [0,0,1,1,1,2,2,3,3,4]
    //输出：5, nums = [0,1,2,3,4]
    public int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index;


    }

}
