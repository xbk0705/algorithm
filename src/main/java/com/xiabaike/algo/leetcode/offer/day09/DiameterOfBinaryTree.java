package com.xiabaike.algo.leetcode.offer.day09;

import com.xiabaike.algo.leetcode.simple.tree.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
public class DiameterOfBinaryTree {

    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    // 深度优先
    // 首先我们知道一条路径的长度为该路径经过的节点数减一，所以求直径（即求路径长度的最大值）等效于求路径经过节点数的最大值减一。
    // 而任意一条路径均可以被看作由某个节点为起点，从其左儿子和右儿子向下遍历的路径拼接得到。
    public int depth(TreeNode root) {
        if (root == null) {
            // 访问到空节点了，返回0
            return 0;
        }
        // 左儿子为根的子树的深度
        int lDepth = depth(root.left);
        // 右儿子为根的子树的深度
        int rDepth = depth(root.right);
        // 计算d_node即L+R+1 并更新ans
        ans = Math.max(ans, lDepth + rDepth + 1);
        // 返回该节点为根的子树的深度
        return Math.max(lDepth, rDepth) + 1;
    }

}
