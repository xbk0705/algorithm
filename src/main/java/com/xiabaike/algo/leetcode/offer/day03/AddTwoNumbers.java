package com.xiabaike.algo.leetcode.offer.day03;

import com.xiabaike.algo.leetcode.simple.linkedlist.ListNode;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode newHead = new ListNode(0);
        int add = 0;
        ListNode temp = newHead;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + add;
            int val = sum % 10;
            add = sum / 10;
            ListNode temp1 = new ListNode(val);
            temp.next = temp1;
            temp = temp1;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + add;
            int val = sum % 10;
            add = sum / 10;
            ListNode temp1 = new ListNode(val);
            temp.next = temp1;
            temp = temp1;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + add;
            int val = sum % 10;
            add = sum / 10;
            ListNode temp1 = new ListNode(val);
            temp.next = temp1;
            temp = temp1;
            l2 = l2.next;
        }
        if (add != 0) {
            ListNode temp1 = new ListNode(1);
            temp.next = temp1;
        }
        return newHead.next;
    }

}
