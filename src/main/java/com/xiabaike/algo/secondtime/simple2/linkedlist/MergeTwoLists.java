package com.xiabaike.algo.secondtime.simple2.linkedlist;

import com.xiabaike.algo.leetcode.simple.linkedlist.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]  输出：[1,1,2,3,4,4]
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newNode = new ListNode(0);
        ListNode node = newNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else if (list1.val > list2.val) {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        //然后把那个不为空的链表挂到新的链表中
        node.next = list1 == null ? list2 : list1;
        return newNode.next;
    }

}
