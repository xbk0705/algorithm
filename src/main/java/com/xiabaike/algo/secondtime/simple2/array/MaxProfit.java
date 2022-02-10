package com.xiabaike.algo.secondtime.simple2.array;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 输入：[7,1,5,3,6,4]  输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 */
public class MaxProfit {

    // 动态规划
    public int maxProfit(int[] prices) {
        // 第i天没持有股票的利润：
        //  如果i天没买没卖，则最大利润等于i-1天没持有股票的利润
        //  如果i天有卖出股票，则最大利润等于i-1天持有股票的利润加上i天卖出的最大利润
        // NOT(i) = max(NOT(i - 1), CHIYOU(i - 1) + prices[i]);
        // 第i天持有股票的利润：
        //  如果i天买入股票，则最大利润等于 -prices[i]
        //  如果i天没买没卖，则最大利润等于i-1天持有股票的利润
        // CHIYOU(i) = max(CHIYOU(i - 1), - prices[i]);
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int not = 0;
        int chiyou = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            not = Math.max(not, chiyou + prices[i]);
            chiyou = Math.max(chiyou, - prices[i]);
        }
        // 最大利润是最后一天卖出股票的最大利润
        return not;
    }

    public int maxProfit2(int[] prices) {
        // 遍历价格数组一遍，记录历史最低点，然后在每一天考虑这么一个问题：如果我是在历史最低点买进的，那么我今天卖出能赚多少钱？
        // 采用双指针
        // 一个指针一直指向目前最小的值
        // 一个指针一直往后走，然后计算他们的差值，保存最大的即可
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.max(min, 0) + prices[i] - prices[i - 1];
            max = Math.max(max, min);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = {7,1,5,3,6,4};
        int lirun = maxProfit.maxProfit3(prices);
        System.out.println(lirun);
    }

}
