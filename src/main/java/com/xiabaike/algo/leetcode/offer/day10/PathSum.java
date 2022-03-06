package com.xiabaike.algo.leetcode.offer.day10;

import com.xiabaike.algo.leetcode.simple.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class PathSum {

    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = dfs(root, targetSum, map, 0);
        return res;
    }

    private int dfs(TreeNode root, int target, Map<Integer, Integer> map, int curr) {
        if (root == null) {
            return 0;
        }
        curr += root.val;
        int res = map.getOrDefault(curr - target, 0);
        map.put(curr, map.getOrDefault(curr, 0) + 1);
        res += dfs(root.left, target, map, curr);
        res += dfs(root.right, target, map, curr);
        map.put(curr, map.getOrDefault(curr, 0) - 1);
        return res;
    }

}
