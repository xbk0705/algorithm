package com.xiabaike.sensorsdata.sample.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr  = {2,7,11,15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        int[] re = twoSum.twoSum2(arr, target);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] re = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    re[0] = i;
                    re[1] = j;
                    break;
                }
            }
        }
        return re;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }

}
