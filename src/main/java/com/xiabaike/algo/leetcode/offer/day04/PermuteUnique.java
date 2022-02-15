package com.xiabaike.algo.leetcode.offer.day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 输入：nums = [1,1,2] 输出：[[1,1,2], [1,2,1], [2,1,1]]
 * 输入：nums = [1,2,3] 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] exits = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(resList, list, exits, nums);
        return resList;
    }

    public void dfs(List<List<Integer>> resList, List<Integer> list, boolean[] exits, int[] nums) {
        if (list.size() == nums.length) {
            resList.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // 注意此处判断，要去掉重复数据
                // 前一个元素被使用过，我们要剪枝
                if (exits[i] || (i > 0 && nums[i] == nums[i - 1] && !exits[i - 1])) {
                    continue;
                }
                list.add(nums[i]);
                exits[i] = true;
                dfs(resList, list, exits, nums);
                exits[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

}
