package com.xiabaike.algo.leetcode.simple.tree;

import java.util.Stack;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        // 每个节点如果超过这个范围，直接返回false
        if (root.val <= min || root.val >= max) {
            return false;
        }
        // 这里再分别以左右两个子节点分别判断，
        // 左子树范围的最小值是minVal，最大值是当前节点的值，也就是root的值，因为左子树的值要比当前节点小
        // 右子数范围的最大值是maxVal，最小值是当前节点的值，也就是root的值，因为右子树的值要比当前节点大
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public boolean isValidBST2(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val)
                return false;
            //保存前一个访问的结点
            pre = root;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        IsValidBST isValidBST = new IsValidBST();
        TreeNode treeNode = new TreeNode(0);
        isValidBST.isValidBST(treeNode);
    }

}
