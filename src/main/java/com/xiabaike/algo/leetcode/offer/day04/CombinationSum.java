package com.xiabaike.algo.leetcode.offer.day04;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，
 * 找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 *
 * 输入：candidates = [2,3,6,7], target = 7  输出：[[2,2,3],[7]]
 * 输入: candidates = [2,3,5], target = 8  输出: [[2,2,2,2],[2,3,3],[3,5]]
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        List<Integer> path = new ArrayList<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    // 排列问题，讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为不同列表时），需要记录哪些数字已经使用过，此时用 used 数组；
    // 组合问题，不讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为相同列表时），需要按照某种顺序搜索，此时使用 begin 变量。
    // 遇到这一类相同元素不计算顺序的问题，我们在搜索的时候就需要 按某种顺序搜索。每一次搜索的时候设置 下一轮搜索的起点 begin
    private void dfs(int[] candidates, int begin, int len, int target, List<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            path.add(candidates[i]);

            dfs(candidates, i, len, target - candidates[i], path, res);

            path.remove(path.size() - 1);
        }
    }

}
