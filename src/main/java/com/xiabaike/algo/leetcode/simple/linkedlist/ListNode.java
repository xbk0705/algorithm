package com.xiabaike.algo.leetcode.simple.linkedlist;

public class ListNode {

    public Integer val;
    public ListNode next;

    public ListNode(Integer val) {
        this.val = val;
    }

    public ListNode(Integer val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

}
