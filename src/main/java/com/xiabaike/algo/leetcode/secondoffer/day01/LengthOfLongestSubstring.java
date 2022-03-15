package com.xiabaike.algo.leetcode.secondoffer.day01;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"  输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: s = "bbbbb"     输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int right = -1;
        int len = s.length();
        int max = 0;
        for (int left = 0; left < len; left++) {
            if (left != 0) {
                set.remove(s.charAt(left - 1));
            }

            while (right + 1 < len && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }


}
