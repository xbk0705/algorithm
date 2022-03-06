package com.xiabaike.algo.leetcode.offer.day09;

/**
 * 给定一个整数数组prices，其中第prices[i]表示第i天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 输入: prices = [1,2,3,0,2]  输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // 当前持有股票的收益f[i][0]=max(f[i−1][0],f[i−1][2]−prices[i])
        // 当前没有股票且不在冷冻期的收益f[i][2]=max(f[i−1][1],f[i−1][2])
        // 当前没有股票且在冷冻期的收益f[i][1]=f[i−1][0]+prices[i]
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int i = 1; i < prices.length; i++) {
            int newf0 = Math.max(f0, f2 - prices[i]);
            int newf1 = f0 + prices[i];
            int newf2 = Math.max(f1, f2);
            f0 = newf0;
            f1 = newf1;
            f2 = newf2;
        }
        return Math.max(f1, f2);
    }

}
