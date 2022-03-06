package com.xiabaike.algo;

import com.xiabaike.algo.leetcode.simple.tree.TreeNode;

import java.util.LinkedList;

public class Zhihu {

    public static void main(String[] args) {
        // 二叉树的层次优先
        Zhihu zhihu = new Zhihu();



    }

    public void bfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.pop();
            System.out.println(tmp.val);
            if (tmp.left != null) {
                queue.offer(tmp.left);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
        }
    }

}
