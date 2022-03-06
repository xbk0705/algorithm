package com.xiabaike.algo.leetcode.offer.day09;

import com.xiabaike.algo.leetcode.simple.tree.TreeNode;

import java.util.LinkedList;

/**
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
 * 你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；
 * 否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。
 * 注意: 合并过程必须从两个树的根节点开始。
 *
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 */
public class MergeTrees {

    // 广度优先
    // 时间复杂度：O(min(m,n))
    // 空间复杂度：O(min(m,n))
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue.offer(root);
        queue1.offer(root1);
        queue2.offer(root2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode tmp = queue.poll();
            TreeNode tmp1 = queue1.poll();
            TreeNode tmp2 = queue2.poll();
            TreeNode left1 = tmp1.left;
            TreeNode left2 = tmp2.left;
            TreeNode right1 = tmp1.right;
            TreeNode right2 = tmp2.right;
            if (left1 != null && left2 != null) {
                TreeNode left = new TreeNode(left1.val + left2.val);
                tmp.left = left;
                queue.offer(left);
                queue1.offer(left1);
                queue2.offer(left2);
            } else if (left1 != null) {
                tmp.left = left1;
            } else if (left2 != null) {
                tmp.left = left2;
            }
            if (right1 != null && right2 != null) {
                TreeNode right = new TreeNode(right1.val + right2.val);
                tmp.right = right;
                queue.offer(right);
                queue1.offer(right1);
                queue2.offer(right2);
            } else if (right1 != null) {
                tmp.right = right1;
            } else if (right2 != null) {
                tmp.right = right2;
            }
        }
        return root;
    }

    // 深度优先
    // 时间复杂度：O(min(m,n))
    // 空间复杂度：O(min(m,n))
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees2(root1.left, root2.left);
        node.right = mergeTrees2(root1.right, root2.right);
        return node;
    }

}
