package com.xiabaike.algo.leetcode.offer.day06;

import com.xiabaike.algo.leetcode.simple.tree.TreeNode;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * 输入：root = [1,2,3]  输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 */
public class MaxPathSum {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max(root);
        return maxSum;
    }

    public int max(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 左边的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftMax = Math.max(max(root.left), 0);
        // 右边的最大贡献值
        int rightMax = Math.max(max(root.right), 0);

        // 当前结点的最大路径和
        int a = root.val + leftMax + rightMax;
        maxSum = Math.max(maxSum, a);

        // 结点的最大贡献值
        return root.val + Math.max(leftMax, rightMax);
    }

}
