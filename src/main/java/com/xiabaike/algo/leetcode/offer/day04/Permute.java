package com.xiabaike.algo.leetcode.offer.day04;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 输入：nums = [1,2,3] 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 输入：nums = [0,1] 输出：[[0,1],[1,0]]
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> list = new ArrayList();
        dfs(resList, list, nums);
        return resList;
    }

    // 排列问题，讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为不同列表时），需要记录哪些数字已经使用过，此时用 used 数组；
    // 组合问题，不讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为相同列表时），需要按照某种顺序搜索，此时使用 begin 变量。
    public static void dfs(List<List<Integer>> resList, List<Integer> list, int[] num) {
        // 终结条件
        if (list.size() == num.length) {
            // 满足条件，加入结果集
            resList.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < num.length; i++) {
                // 剪枝
                if (list.contains(num[i])) {
                    continue;
                }

                list.add(num[i]);
                dfs(resList, list, num);
                list.remove(list.size() - 1);
            }
        }
    }

}
