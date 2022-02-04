package com.xiabaike.algo.leetcode.offer.day01;

import java.util.Arrays;

/**
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * 输入：n = 2  输出：[0,1,1]   解释： 0 --> 0   1 --> 1   2 --> 10
 */
public class CountBits {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = count(i);
        }
        return result;
    }

    private int count(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }

    public static void main(String[] args) {
        CountBits countBits = new CountBits();
        int[] result = countBits.countBits(5);
        System.out.println(Arrays.toString(result));

        System.out.println(Integer.bitCount(5));
    }

}
