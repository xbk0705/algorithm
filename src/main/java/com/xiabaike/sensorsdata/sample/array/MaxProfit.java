package com.xiabaike.sensorsdata.sample.array;

public class MaxProfit {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                sum = sum + prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    public int maxProfit2(int[] prices) {
        int[][] profix = new int[prices.length][2];
        // 0 表示当前 0 没有股票的最大利润
        profix[0][0] = 0;
        // 1 表示当前 1 有股票的最大利润
        profix[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 没有股票 = max (前一天也没有股票的最大利润，前一天有股票当天卖掉股票后的最大利润)
            profix[i][0] = Math.max(profix[i - 1][0], profix[i - 1][1] + prices[i]);
            // 有股票 = max （前一天有股票的最大利润， 前一天没有股票当天买入股票的最大利润）
            profix[i][1] = Math.max(profix[i - 1][1], profix[i - 1][0] - prices[i]);
        }
        return profix[prices.length - 1][0];
    }

    public int maxProfit3(int[] prices) {
        int hold = -prices[0];
        int noHold = 0;
        for (int i = 1; i < prices.length; i++) {
            noHold = Math.max(noHold, hold + prices[i]);
            hold = Math.max(hold, noHold - prices[i]);
        }
        return noHold;
    }

    // 贪心算法
    public int maxProfit4(int[] prices) {
        int index = 0;
        int sum = 0;
        while (index < prices.length) {
            // 找到最小值
            while (index + 1 < prices.length && prices[index] >= prices[index + 1]) {
                index++;
            }
            int min = prices[index];
            // 找到最大值
            while (index + 1 < prices.length && prices[index] < prices[index + 1]) {
                index++;
            }
            int max = prices[index];
            index++;
            sum = sum + max - min;
        }
        return sum;
    }
}
