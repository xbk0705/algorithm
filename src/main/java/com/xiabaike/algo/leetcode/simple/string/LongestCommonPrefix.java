package com.xiabaike.algo.leetcode.simple.string;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 输入：strs = ["flower","flow","flight"]   输出："fl"
 * 输入：strs = ["dog","racecar","car"]  输出：""  解释：输入不存在公共前缀。
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String prefix = strs[0];
        int length = prefix.length();
        for (int i = 0; i < length; i++) {
            int match = 0;
            prefix = prefix.substring(0, length - i);
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(prefix)) {
                    break;
                } else {
                    match++;
                }
            }
            if (match == strs.length - 1) {
                return prefix;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        LongestCommonPrefix commonPrefix = new LongestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"dog","racecar","car"};
        String prefix = commonPrefix.longestCommonPrefix(strs);
        System.out.println(prefix);
    }

}
