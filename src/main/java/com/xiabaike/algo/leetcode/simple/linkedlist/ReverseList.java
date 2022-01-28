package com.xiabaike.algo.leetcode.simple.linkedlist;

import java.util.Stack;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]  输出：[5,4,3,2,1]
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        // 把链表节点全部摘掉放到栈中
        while(head != null) {
            stack.push(head);
            head = head.next;
        }

        // 栈中的结点全部出栈，然后重新连成一个新的链表
        // 新链表的一个结点，即尾结点
        ListNode node = stack.pop();
        // 新链表头结点
        ListNode newHead = node;
        while (!stack.empty()) {
            // 出栈一个结点
            ListNode temp = stack.pop();
            // 把新链表的下一个指针指向temp
            node.next = temp;
            // 把新链表的下一个结点当做要处理的结点
            node = node.next;
        }

        // 最后一个结点就是反转前的头结点，一定要让他的next等于空，否则会构成环
        node.next = null;
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        // 新链表
        ListNode node = null;
        while (head != null) {
            // 先保存访问的结点的下一个结点
            // temp = 3, head = 2
            ListNode temp = head.next;
            // 每次访问的原链表结点都会成为新链表的头结点
            // 其实就把新链表挂到访问的原链表结点的后面就可以了
            // node = 1, head = 2, head.next = 3 -> 1
            // temp成为临时的原链表的头结点，head作为原链表要被摘除的结点即新链表的头结点
            // 也就是把head从原链表摘除，放到新链表头部
            head.next = node;
            // 更新新链表
            // head = 2, node = 1 -> 2
            node = head;
            // 重新赋值，继续访问
            // tem = 3, head = 2 -> 3
            head = temp;
        }
        return node;
    }

    // 使用递归
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newNode = reverseList3(next);
        next.next = head;
        head.next = null;
        return newNode;
    }

    // 使用尾递归
    // 在链表递归的时候从前往后处理，处理完之后直接返回递归的结果
    public ListNode reverseList4(ListNode head) {
        return reverse(head, null);
    }

    private static ListNode reverse(ListNode head, ListNode newNode) {
        if (head == null) {
            return newNode;
        }
        ListNode next = head.next;
        head.next = newNode;
        return reverse(next, head);
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode newNode = reverseList.reverseList2(node1);
        String temp = "";

    }

}
