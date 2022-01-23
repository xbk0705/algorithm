package com.xiabaike.algo.leetcode.simple.linkedlist;

import java.util.Stack;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]  输出：[5,4,3,2,1]
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node;
        while ((node = head.getNext()) != null) {
            stack.push(node);
        }

        ListNode newNode = stack.pop();
        while (!stack.empty()) {
            ListNode node1 = stack.pop();
            newNode.setNext(node1);
            newNode = newNode.getNext();
        }

        newNode.setVal(null);
        return newNode;
    }

}
