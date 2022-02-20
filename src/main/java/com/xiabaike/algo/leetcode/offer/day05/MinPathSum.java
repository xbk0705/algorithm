package com.xiabaike.algo.leetcode.offer.day05;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]  输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 */
public class MinPathSum {

    // 动态规划
    public int minPathSum(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) {
                    // 当左边和上边都是矩阵边界时： 即当i=0,j=0时，其实就是起点
                    continue;
                } else if(i == 0) {
                    // 当只有左边是矩阵边界时： 只能从上面来
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if(j == 0) {
                    // 当只有上边是矩阵边界时： 只能从左面来
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    // 当左边和上边都不是矩阵边界时
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

}
