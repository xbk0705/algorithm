package com.xiabaike.sensorsdata.sample.linkedlist;

import com.xiabaike.algo.leetcode.simple.linkedlist.ListNode;

public class DeleteNode {

    // 输入：head = [4,5,1,9], node = 5
    // 输出：[4,1,9]
    public void deleteNode(ListNode node) {
        // 先替换 node 中的 val 为 node.next 的 val
        // 4 -> 1 -> 1 -> 9
        node.val = node.next.val;
        // 删除 node 结点，即把 node 结点的下一结点指针指向 node 下一结点的下一结点
        // 也就是删除 node 的下一结点
        // 4 -> 1 -> 9
        node.next = node.next.next;
    }

}
