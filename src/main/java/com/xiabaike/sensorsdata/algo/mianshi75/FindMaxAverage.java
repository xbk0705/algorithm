package com.xiabaike.sensorsdata.algo.mianshi75;

public class FindMaxAverage {

    public static void main(String[] args) {
        int[] nums = {0,1,1,3,3};
        int k = 4;
        FindMaxAverage findMaxAverage = new FindMaxAverage();
        double re = findMaxAverage.findMaxAverage(nums, k);
        System.out.println(re);
    }

    public double findMaxAverage(int[] nums, int k) {

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        System.out.println(sum);
        for (int i = k; i < nums.length; i++) {
            System.out.println(sum - nums[k - i] + nums[i]);
            if (sum - nums[k - i] + nums[i] > sum) {
                sum = sum - nums[k - i] + nums[i];
            }
        }

        return 1.0 * sum / k;

    }

}
