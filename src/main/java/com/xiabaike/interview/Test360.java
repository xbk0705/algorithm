package com.xiabaike.interview;

import com.xiabaike.algo.leetcode.simple.linkedlist.ListNode;

import java.util.Stack;

public class Test360 {

    public ListNode reverse(ListNode node) {
        if (node == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        ListNode newNode = new ListNode(0);
        ListNode head = newNode;
        while (!stack.empty()) {
            ListNode tmp = stack.pop();
            newNode.next = tmp;
            newNode = tmp;
        }

        return head.next;
    }

    public ListNode reverse2(ListNode node) {
        ListNode newNode = null;
        // 1 -> 2 -> 3 -> 4
        while (node != null) {
            ListNode tmp = node.next;
            node.next = newNode;
            newNode = node;
            node = tmp;
        }
        return newNode;
    }

    //

    public static void main(String[] args) {
        Test360 test360 = new Test360();
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode newNode = test360.reverse2(node);
        System.out.println(newNode.val);
        System.out.println(newNode.next.val);
    }




}
