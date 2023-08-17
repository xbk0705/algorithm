package com.xiabaike.interview;

public class Shence {

    // 逆转单链表
    public static LinkedNode reverse(LinkedNode node) {
        if (node == null) {
            return null;
        }
        LinkedNode newNode = null;
        // 1 -> 2 -> 3 -> 4
        while (node != null) {
            LinkedNode tmp = node.next;
            node.next = newNode;
            newNode = node;
            node = tmp;
        }
        return newNode;
    }

    public static void main(String[] args) {
        LinkedNode node1 = null;
        LinkedNode newNode = reverse(node1);
        System.out.println(newNode);
//        LinkedNode node1 = new LinkedNode(1);
//        LinkedNode node2 = new LinkedNode(2);
//        LinkedNode node3 = new LinkedNode(3);
//        LinkedNode node4 = new LinkedNode(4);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//
//        LinkedNode newNode = reverse(node1);
//        System.out.println(newNode.value);
//        System.out.println(newNode.next.value);
    }


    static class LinkedNode {
        int value;
        LinkedNode next;

        LinkedNode(int value) {
            this.value = value;
        }
    }
}
