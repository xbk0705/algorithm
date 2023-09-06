package com.xiabaike.sensorsdata.sample.array;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    // 输入：nums = [4,1,2,1,2]
    // 输出：4
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]));
            } else {
                map.put(nums[i], 5);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num |= nums[i];
        }
        return num;
    }

}
