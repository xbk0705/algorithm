package com.xiabaike.algo.leetcode.simple.linkedlist;

/**
 * @author xiabaike <xiabaike@kuaishou.com>
 * Created on 2022-01-24
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        // 通过快慢指针找到中点
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = head.next.next;
            slow = head.next;
        }
        // 如果fast不为空，说明链表的长度是奇数个
        if (fast != null) {
            slow = slow.next;
        }
        // 反转后半部分链表
        slow = reverse(slow);

        fast = head;
        while (fast != null && slow != null) {
            // 然后比较，判断节点值是否相等
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode node = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }
        return node;
    }


}
