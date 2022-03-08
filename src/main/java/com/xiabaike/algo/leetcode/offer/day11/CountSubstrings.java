package com.xiabaike.algo.leetcode.offer.day11;

/**
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 输入：s = "abc"  输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 输入：s = "aaa"  输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */
public class CountSubstrings {

    // 动态规划
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    count++;
                }
            }
        }

        return count;
    }

    // 中心扩展法
    public int countSubstrings2(String s) {
        int count = 0;
        for (int i = 0; i < s.length() * 2 - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                count++;
            }
        }
        return count;
    }

}
