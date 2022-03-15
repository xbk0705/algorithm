package com.xiabaike.algo.leetcode.offer.day11;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 输入：s = "babad"   输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 输入：s = "cbbd"    输出："bb"
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
//            extend(s, res, i, i);
//            extend(s, res, i, i + 1);
        }
        return res;
    }

    private String extend(String s, int left, int right) {
        String res = "";
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            if (right - left + 1 > s.length()) {
                res = s.substring(left, right - left + 1);
            }
        }
        return res;
    }

}
