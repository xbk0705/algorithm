package com.xiabaike.algo.leetcode.offer.day03;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]   (8,7)输出：49
 * 输入：height = [4,3,2,1,4]  (4,4)输出：16
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int min = Math.min(height[i], height[j]);
                int mul = min * (j - i);
                max = Math.max(max, mul);
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int mul = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(max, mul);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = maxArea.maxArea(height);
        System.out.println(result);
    }

}
