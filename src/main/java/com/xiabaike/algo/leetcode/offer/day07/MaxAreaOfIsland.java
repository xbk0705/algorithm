package com.xiabaike.algo.leetcode.offer.day07;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
 * 你可以假设grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int rl = grid.length;
        int cl = grid[0].length;
        int max = 0;
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                if (grid[i][j] == 1) {
                    int ar = area(grid, i, j);
                    max = Math.max(ar, max);
                }
            }
        }
        return max;
    }

    public int area(int[][] grid, int r, int c) {
        int rl = grid.length;
        int cl = grid[0].length;
        if (r < 0 || c < 0 || r >= rl || c >= cl || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        return 1 +
                area(grid, r + 1, c) +
                area(grid, r - 1, c) +
                area(grid, r, c + 1) +
                area(grid, r, c - 1);
    }

}
