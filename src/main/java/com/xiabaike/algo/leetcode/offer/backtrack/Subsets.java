package com.xiabaike.algo.leetcode.offer.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(resList, nums, 0, list);
        return resList;
    }

    // 回溯
    public void dfs(List<List<Integer>> resList, int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            resList.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        // 考虑选择当前位置
        dfs(resList, nums, index + 1, list);
        list.remove(list.size() - 1);
        // 考虑不选择当前位置
        dfs(resList, nums, index + 1, list);
    }

    public void dfs2(List<List<Integer>> resList, int[] nums, int index, List<Integer> list) {
        resList.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(resList, nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
