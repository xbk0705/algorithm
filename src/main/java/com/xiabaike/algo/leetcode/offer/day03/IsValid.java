package com.xiabaike.algo.leetcode.offer.day03;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 输入：s = "()"   输出：true
 * 输入：s = "()[]{}"   输出：true
 * 输入：s = "(]"   输出：false
 */
public class IsValid {

    public boolean isValid(String s) {

        if (s == null || s.length() < 2) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        int index = 1;
        while (index < s.length() && !stack.empty()) {
            char ch = s.charAt(index);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                char tmp = stack.pop();
                if (ch == ')' && tmp != '(') {
                    return false;
                }
                if (ch == '}' && tmp != '{') {
                    return false;
                }
                if (ch == ']' && tmp != '[') {
                    return false;
                }
            }
            index++;
        }

        if (!stack.empty()) {
            return false;
        }
        return true;
    }

}
