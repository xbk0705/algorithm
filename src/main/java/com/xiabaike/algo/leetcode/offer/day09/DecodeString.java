package com.xiabaike.algo.leetcode.offer.day09;

import java.util.Stack;

/**
 *
 */
public class DecodeString {

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                // 把所有的字母push进去，除了]
                stack.push(c);
            } else {
                StringBuilder sb = new StringBuilder();
                // 取出字母
                while (!stack.empty() && Character.isLetter(stack.peek())) {
                    sb.append(stack.pop());
                }
                String sub = sb.reverse().toString();
                // 取出[
                stack.pop();
                sb = new StringBuilder();
                // 取出数字
                while (!stack.empty() && Character.isDigit(stack.peek())) {
                    sb.append(stack.pop());;
                }
                int num = Integer.parseInt(sb.reverse().toString());
                // 把取出的字母，按照num倍数push回stack
                while (num > 0) {
                    for (char c1 : sub.toCharArray()) {
                        stack.push(c1);
                    }
                    num--;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.empty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

}
