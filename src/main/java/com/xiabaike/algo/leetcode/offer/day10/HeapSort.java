package com.xiabaike.algo.leetcode.offer.day10;

import java.util.Arrays;

public class HeapSort {

    public void sort(int[] nums) {
        // 构建大顶堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            // 从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(nums, i, nums.length);
        }

        // 调整堆结构+交换堆顶元素与末尾元素
        for (int j = nums.length - 1; j > 0; j--) {
            // 将堆顶元素与末尾元素进行交换
            int tmp = nums[j];
            nums[j] = nums[0];
            nums[0] = tmp;
            // 重新对堆进行调整
            adjustHeap(nums, 0, j);
        }

    }

    public void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];
        // 从i结点的左子节点开始，也就是2i+1处开始
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 如果左子节点小于右子节点，k指向右子节点
            if (k + 1 < length && nums[k] < nums[k + 1]) {
                k++;
            }
            // 如果子节点大于父节点，将子节点赋值给父节点
            if (nums[k] > temp) {
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
        }
        // 将temp值放到最终位置
        nums[i] = temp;
    }

    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        int[] nums = {3,7,1,2,4,8,5,9,6};
        sort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
