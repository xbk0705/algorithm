package com.xiabaike.sensorsdata.sample.linkedlist;

import com.xiabaike.algo.leetcode.simple.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node.next != null) {
            list.add(node);
            node = node.next;
        }

        node = list.get(list.size() - n);
        node.val = node.next.val;
        node.next = node.next.next;
        return head;
    }

}
