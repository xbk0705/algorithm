package com.xiabaike.algo.leetcode.offer.day06;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, LinkedNode> map = new HashMap<>();

    private LinkedNode head;
    private LinkedNode tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LinkedNode node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;

            head.next.pre = node;
            node.next = head.next;

            head.next = node;
            node.pre = head;
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LinkedNode node = map.get(key);
            node.value = value;
            node.pre.next = node.next;
            node.next.pre = node.pre;

            head.next.pre = node;
            node.next = head.next;

            head.next = node;
            node.pre = head;
        } else {
            LinkedNode node = new LinkedNode(key, value);
            if (map.size() == capacity) {
                map.remove(tail.pre.key);
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;

                head.next.pre = node;
                node.next = head.next;

                head.next = node;
                node.pre = head;
                map.put(key, node);
            } else {
                head.next.pre = node;
                node.next = head.next;

                head.next = node;
                node.pre = head;
                map.put(key, node);
            }
        }

    }

    class LinkedNode{
        int key;
        int value;
        LinkedNode pre;
        LinkedNode next;
        public LinkedNode() {}
        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }
}
