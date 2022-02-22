package com.xiabaike.algo.leetcode.offer.day07;

/**
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 */
public class NumIslands {

    // 深度优先
    // 扫描整个二维网格。如果一个位置为 11，则以其为起始节点开始进行深度优先搜索。
    // 在深度优先搜索的过程中，每个搜索到的 11 都会被重新标记为 00。
    // 最终岛屿的数量就是我们进行深度优先搜索的次数。
    public int numIslands(char[][] grid) {
        int c = grid.length;
        int r = grid[0].length;
        int count = 0;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int c1, int r1) {
        int c = grid.length;
        int r = grid[0].length;
        if (c1 < 0 || r1 < 0 || c1 >= c || r1 >= r || grid[c1][r1] == '0') {
            return;
        }
        grid[c1][r1] = '0';
        dfs(grid, c1 - 1, r1);
        dfs(grid, c1 + 1, r1);
        dfs(grid, c1, r1 - 1);
        dfs(grid, c1, r1 + 1);
    }

}
