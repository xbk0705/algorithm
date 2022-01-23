package com.xiabaike.algo.leetcode.simple.string;

import java.util.Arrays;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 输入：s = ["h","e","l","l","o"]   输出：["o","l","l","e","h"]
 * 输入：s = ["H","a","n","n","a","h"]   输出：["h","a","n","n","a","H"]
 */
public class ReverseString {

    public void reverseString(char[] s) {
        if (s == null || s.length < 2) {
            return;
        }

        int length = s.length;
        int mid = length / 2;
        for (int i = 0; i < mid; i++) {
            char temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
//        char[] s = {'h','e','l','l','o'};
        char[] s = {'H','a','n','n','a','h'};
        reverseString.reverseString(s);
    }


}
