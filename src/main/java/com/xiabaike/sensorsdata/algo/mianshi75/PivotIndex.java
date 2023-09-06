package com.xiabaike.sensorsdata.algo.mianshi75;

public class PivotIndex {

    public static void main(String[] args) {
        int[] arr = {-1,-1,-1,-1,-1,-1};

        PivotIndex pivotIndex = new PivotIndex();
        int index = pivotIndex.pivotIndex(arr);
        System.out.println(index);
    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            double s = 1.0 * (sum - nums[i]) / 2;
            if (s == preSum) {
                return i;
            }
            preSum += nums[i];
        }

        return -1;
    }

}
