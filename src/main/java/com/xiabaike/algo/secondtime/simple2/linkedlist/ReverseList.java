package com.xiabaike.algo.secondtime.simple2.linkedlist;

import com.xiabaike.algo.leetcode.simple.linkedlist.ListNode;

import java.util.Stack;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 输入：head = [1,2,3,4,5]  输出：[5,4,3,2,1]
 * 输入：head = [1,2]  输出：[2,1]
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty())
            return null;
        ListNode node = stack.pop();
        ListNode newHead = node;
        while (!stack.empty()) {
            ListNode tmp = stack.pop();
            node.next = tmp;
            node = tmp;
        }
        node.next = null;
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode node = new ListNode(0);
        while (head != null) {
            ListNode tmp = head.next;
            node.next = head;
            node = head;
            head = tmp;
        }
        return node.next;
    }
}
