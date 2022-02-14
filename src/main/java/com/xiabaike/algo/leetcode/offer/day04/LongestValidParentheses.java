package com.xiabaike.algo.leetcode.offer.day04;

import java.util.Stack;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * 输入：s = "(()"  输出：2  解释：最长有效括号子串是 "()"
 * 输入：s = ")()())"  输出：4  解释：最长有效括号子串是 "()()"
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {

        // 在遍历给定字符串的过程中去判断到目前为止扫描的子串的有效性，同时能得到最长有效括号的长度。
        // 始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                // 对于遇到的每个 ‘(’ ，我们将它的下标放入栈中
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    // 如果栈为空，说明当前的右括号为没有被匹配的右括号，
                    // 我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
                    stack.push(i);
                } else {
                    // 如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }

}
