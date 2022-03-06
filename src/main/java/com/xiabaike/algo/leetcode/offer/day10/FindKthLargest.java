package com.xiabaike.algo.leetcode.offer.day10;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2  输出: 5
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4  输出: 4
 */
public class FindKthLargest {

    // 构建大根堆，最小堆
    // 时间复杂度：O(NlogK)，遍历数据 O(N)，堆内元素调整 O(logK)
    // 空间复杂度：O(K)
    public int findKthLargest(int[] nums, int k) {
        // 使用一个含有 k 个元素的最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            int tmp = queue.peek();
            // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
            if (nums[i] > tmp) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        int target = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    private Random random = new Random(Integer.MAX_VALUE);
    // 在区间 nums[left..right] 区间执行 partition 操作
    // 返回 nums[left] 排序以后应该在的位置
    private int partition(int[] nums, int left, int right) {
        // 在区间随机选择一个元素作为标定点
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] < pivot) {
                // j 的初值为 left，先右移，再交换，小于 pivot 的元素都被交换到前面
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

}
