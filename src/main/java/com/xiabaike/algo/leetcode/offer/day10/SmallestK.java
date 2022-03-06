package com.xiabaike.algo.leetcode.offer.day10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4  输出： [1,2,3,4]
 */
public class SmallestK {

    public int[] smallestK(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int size = 0;
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (size < k) {
                int count = map.getOrDefault(arr[i], 0);
                map.put(arr[i], count + 1);
                min = Math.min(min, arr[i]);
                size++;
            } else {
                if (min < arr[i]) {
                    map.remove(min);
                    int count = map.getOrDefault(arr[i], 0);
                    map.put(arr[i], count + 1);
                    min = arr[i];
                }
            }
        }

        int[] res = new int[k];
        int index = 0;
        System.out.println(map.size());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res[index++] = entry.getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        SmallestK smallestK = new SmallestK();
        int[] arr = {1,3,5,7,2,4,6,8};
        int[] res = smallestK.smallestK(arr, 4);
        System.out.println(Arrays.toString(res));
    }

}
