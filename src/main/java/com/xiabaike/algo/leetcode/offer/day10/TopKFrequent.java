package com.xiabaike.algo.leetcode.offer.day10;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 输入: nums = [1,1,1,2,2,3], k = 2    输出: [1,2]
 * 输入: nums = [1], k = 1              输出: [1]
 */
public class TopKFrequent {

    // 堆排序
    public int[] topKFrequent(int[] nums, int k) {

        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[2];
            }
        });

        // 遍历map，用最小堆保存频率最大的k个元素
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] arr = {entry.getKey(), entry.getValue()};
            if (queue.size() < k) {
                queue.offer(arr);
            } else {
                int[] tmp = queue.peek();
                if (tmp[1] < entry.getValue()) {
                    queue.poll();
                    queue.offer(arr);
                }
            }
        }

        // // 取出最小堆中的元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if (queue.isEmpty()) {
                break;
            }
            int[] arr = queue.poll();
            res[i] = arr[0];
        }

        return res;
    }

    // 桶排序
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 桶排序
        // 将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (list[entry.getValue()] == null) {
                list[entry.getValue()] = new ArrayList<>();
            }
            list[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        // 倒序遍历数组获取出现顺序从大到小的排列
        for (int i = list.length - 1; i >= 0; i++) {
            if (index == k) {
                break;
            }
            if (list[i] == null) {
                continue;
            }
            for (int n : list[i]) {
                res[index++] = n;
            }
        }
        return res;
    }

}
