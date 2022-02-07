package com.xiabaike.algo.leetcode.offer.day03;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"   输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LengthOfLongestSubstring {

    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<>();
        int right = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(i - 1));
            }

            while (right < s.length() && !set.contains(s.charAt(right))) {
                // 不断地移动右指针
                set.add(s.charAt(right));
                right++;
            }
            max = Math.max(max, right - i);
        }

        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        int max = lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb");
        System.out.println(max);
    }

}
