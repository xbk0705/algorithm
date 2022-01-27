package com.xiabaike.algo.leetcode.simple.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.push(root);
        List<Integer> l = new ArrayList<>();
        l.add(root.val);
        list.add(l);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = linkedList.pop();
                if (temp.left != null) {
                    linkedList.addLast(temp.left);
                    l.add(temp.left.val);
                }
                if (temp.right != null) {
                    linkedList.addLast(temp.right);
                    l.add(temp.right.val);
                }
            }
            if (l.size() > 0) {
                list.add(l);
            }
        }
        return list;
    }

}
