package com.xiabaike.algo.leetcode.simple.sort;

/**
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3  输出：[1,2,2,3,5,6]
 */
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int end = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[end--] = nums1[i--];
            } else {
                nums1[end--] = nums2[j--];
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                temp[index++] = nums2[j];
            } else {
                temp[index++] = nums2[i];
            }
        }
        for (;i < m;) {
            temp[index++] = nums1[i];
        }
        for (;j < n;) {
            temp[index++] = nums2[i];
        }
        for (int x = 0; x < m + n; x++) {
            nums1[x] = temp[x];
        }
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge.merge2(nums1, m, nums2, n);
    }

}
