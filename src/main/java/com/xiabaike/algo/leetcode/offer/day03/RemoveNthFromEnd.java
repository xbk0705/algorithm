package com.xiabaike.algo.leetcode.offer.day03;

import com.xiabaike.algo.leetcode.simple.linkedlist.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 输入：head = [1,2,3,4,5], n = 2   输出：[1,2,3,5]
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = length(head);
        ListNode tmp = head;
        for (int i = 0; i < length - n + 1; i++) {
            tmp = tmp.next;
        }
        tmp.val = tmp.next.val;
        tmp.next = tmp.next.next;
        return head;
    }

    private static int length(ListNode listNode) {
        int length = 0;
        while (listNode != null) {
            listNode = listNode.next;
            length++;
        }
        return length;
    }

}
