package com.xiabaike.algo.leetcode.simple.linkedlist;

/**
 * 请编写一个函数，用于删除单链表中某个特定节点 。
 * 在设计函数时需要注意，你无法访问链表的头节点head ，只能直接访问 要被删除的节点 。
 *
 * 题目数据保证需要删除的节点 不是末尾节点
 * @author xiabaike <xiabaike@kuaishou.com>
 * Created on 2022-01-24
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
        // 把下个节点值赋给当前节点
        node.val = node.next.val;
        // 删除下个节点
        node.next = node.next.next;
    }

    public static void main(String[] args) {

    }

}
