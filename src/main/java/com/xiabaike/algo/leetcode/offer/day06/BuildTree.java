package com.xiabaike.algo.leetcode.offer.day06;

import com.xiabaike.algo.leetcode.simple.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 */
public class BuildTree {

    private Map<Integer, Integer> map;

    // 对于前序遍历：
    //   [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
    // 对于中序遍历：
    //   [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return tree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode tree(int[] preorder, int pre_start, int pre_end,
                         int[] inorder, int in_start, int in_end) {
        if (pre_start > pre_end) {
            return null;
        }
        // 前序遍历的第一个结点即为根节点
        TreeNode root = new TreeNode(preorder[pre_start]);
        // 根节点的值
        int rootValue = preorder[pre_start];
        // 根据根节点的值获取其在中序遍历中的下标，因在中序遍历中，根节点前面的即为左子树，所以，由此得到左子树的个数
        int leftNums = map.get(rootValue) - in_start;
        // 生成左子树
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = tree(preorder, pre_start + 1, pre_start + leftNums,
                inorder, in_start, map.get(rootValue) - 1);
        // 生成右子树
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = tree(preorder, pre_start + leftNums + 1, pre_end,
                inorder, map.get(rootValue) + 1, in_end);

        return root;
    }

}
