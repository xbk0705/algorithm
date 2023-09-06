package com.xiabaike.sensorsdata.algo.mianshi75;

import com.xiabaike.algo.leetcode.simple.linkedlist.ListNode;

import java.util.Stack;

public class ReverseList {

    public static void main(String[] args) {


    }

    // 1,2,3,4,5 -> 5,4,3,2,1
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return cur;
    }

    // 1,2,3,4,5 -> 5,4,3,2,1
    public ListNode reverseList2(ListNode head) {

        ListNode pre = null;
        for (ListNode node = head; node != null; node = node.next) {
            pre = new ListNode(node.val, pre);
        }
        return pre;
    }

    // 1,2,3,4,5 -> 5,4,3,2,1
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // node  = 5 head =4
        ListNode node = reverseList3(head.next);
        // head.next =5 -> head.next.next = 4
        head.next.next = head;
        // head.next = 5;
        head.next = null;
        return node;
    }

    // 1,2,3,4,5 -> 5,4,3,2,1
    public ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        ListNode pre = null;
        for (int i = 0; i < stack.size(); i++) {
            ListNode newNode = stack.pop();
            newNode.next = pre;
        }
        return node;
    }

}
