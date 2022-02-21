package com.xiabaike.algo.leetcode.offer.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 输入：nums = [1,2,2]  输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 输入：nums = [0]  输出：[[],[0]]
 */
public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(resList, list, nums, 0);
        return resList;
    }

    public void dfs(List<List<Integer>> resList, List<Integer> list, int[] nums, int start) {
        // 每条路径上所选择的元素组成的数组都是子集，所以都要添加到集合res中
        resList.add(new ArrayList(list));
        // 这里遍历的时候每次都有从之前选择元素的下一个开始，所以这里i的初始值是level
        for (int i = start; i < nums.length; i++) {
            // 去重，剪枝
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            // 选择当前元素
            list.add(nums[i]);
            // 递归到下一层
            dfs(resList, list, nums, i + 1);
            // 撤销选择
            list.remove(list.size() - 1);
        }
    }

}
