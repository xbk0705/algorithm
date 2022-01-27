package com.xiabaike.algo.leetcode.simple.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class MaxDepth {

    // 使用两个栈，一个记录节点的stack栈，一个记录节点所在层数的level栈
    // stack中每个节点在level中都会有一个对应的值，并且他们是同时出栈，同时入栈
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // stack记录的是节点，而level中的元素和stack中的元素是同时入栈同时出栈，并且level记录的是节点在第几层
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> levelStack = new Stack<>();
        stack.push(root);
        int max = 0;
        while (!stack.empty()) {
            // stack中的元素和level中的元素同时出栈
            TreeNode temp = stack.pop();
            int level = levelStack.pop();
            max = Math.max(level, max);
            if (temp.left != null) {
                // 同时入栈
                stack.push(temp.left);
                levelStack.push(level + 1);
            }
            if (temp.right != null) {
                // 同时入栈
                stack.push(temp.right);
                levelStack.push(level + 1);
            }
        }
        return max;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }

    public int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = deque.pop();
                if (temp.left != null) {
                    // addLast 是放在队列尾部，push相当于addFirst，放在队列头部
                    deque.addLast(temp.left);
                }
                if (temp.right != null) {
                    deque.addLast(temp.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        TreeNode treeNode = new TreeNode(0);
        maxDepth.maxDepth(treeNode);
    }

}
