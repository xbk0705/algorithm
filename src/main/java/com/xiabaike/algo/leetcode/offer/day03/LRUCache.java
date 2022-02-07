package com.xiabaike.algo.leetcode.offer.day03;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class LinkedNode {
        int key;
        int value;
        LinkedNode before;
        LinkedNode after;
        LinkedNode() {}
        LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int size = 0;
    // 头结点
    private LinkedNode head = null;
    // 尾结点
    private LinkedNode tail = null;
    private Map<Integer, LinkedNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.after = tail;
        tail.before = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            LinkedNode node = cache.get(key);
            move2Head(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // 缓存中存在，移动到头结点
            LinkedNode node = cache.get(key);
            node.value = value;
            move2Head(node);
        } else {
            // 缓存中不存在，新建结点：
            LinkedNode node = new LinkedNode(key, value);
            if (size < capacity) {
                //  缓存池未满，直接放在头结点
                node.after = head;
                head.before = node;
                head = node;
                size++;
            } else {
                //  缓存池已满，则删除尾结点，新结点放在头结点
                tail.before.after = null;
                cache.remove(tail.key);
                tail = tail.before;

                node.after = head;
                head.before = node;
                head = node;
            }
            cache.put(key, node);
        }

    }

    private void move2Head(LinkedNode node) {
        // 原有位置删除结点
        node.before.after = node.after;
        node.after.before = node.before;
        // 替换头结点
        node.after = head;
        head.before = node;
        head = node;
    }

    private void move2Tail(LinkedNode node) {
        node.before.after = node.after;
        node.after.before = node.before;
        tail.after = node;
        node.before = tail;
        tail = node;
    }

}
