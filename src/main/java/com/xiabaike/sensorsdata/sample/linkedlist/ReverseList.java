package com.xiabaike.sensorsdata.sample.linkedlist;

import com.xiabaike.algo.leetcode.simple.linkedlist.ListNode;

import java.util.Stack;

public class ReverseList {

    // 输入：head = [1,2,3,4,5]
    // 输出：[5,4,3,2,1]
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.empty()) {
            return null;
        }

        ListNode node = stack.pop();
        ListNode tmp = node;
        for (int i = 1; i < stack.size(); i++) {
            ListNode cur = stack.pop();
            node.next = cur;
            node = cur;
        }
        node.next = null;
        return tmp;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode newNode = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newNode;
            newNode = head;
            head = next;
        }
        head.next = null;
        return newNode;

    }

}
