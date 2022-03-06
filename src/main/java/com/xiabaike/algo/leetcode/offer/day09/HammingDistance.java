package com.xiabaike.algo.leetcode.offer.day09;

/**
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 *
 * 输入：x = 1, y = 4   输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int count = 0;
        while (x > 0 || y > 0) {
            int carry1 = x % 2;
            int carry2 = y % 2;
            if (carry1 != carry2) {
                count++;
            }
            x = x / 2;
            y = y / 2;
        }
        return count;
    }

}
