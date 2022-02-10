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
public class MaxProfit2 {

    // 动态规划
    public int maxProfit(int[] prices) {
        // 如果这一天交易完后手里没有股票，那么可能的转移状态为前一天已经没有股票，即 dp[i-1][0]，或者前一天结束的时候手里持有一支股票
        // 即dp[i-1][1]，这时候我们要将其卖出，并获得 prices[i] 的收益。
        //  dp[i][0] = max{dp[i−1][0], dp[i−1][1] + prices[i]}
        // 如果这一天交易完后手里有股票，可能的转移状态为前一天已经持有一支股票，即 dp[i−1][1]，或者前一天结束时还没有股票，即
        // dp[i−1][0]，这时候我们要将其买入，并减少 prices[i] 的收益。
        //  dp[i][1] = max{dp[i−1][1], dp[i−1][0] − prices[i]}
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int not = 0;
        int chiyou = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            not = Math.max(not, chiyou + prices[i]);
            chiyou = Math.max(chiyou, not - prices[i]);
        }
        // 最大利润是最后一天卖出股票的最大利润
        return not;
    }

    // 贪心算法
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 只需要找到股票上涨的最大值和股票开始上涨的最小值，计算他们的差就是这段时间内股票的最大利润。
        // 如果股票下跌就不用计算，最终只需要把所有股票上涨的时间段内的利润累加就是我们所要求的结果
        int length = prices.length;
        int total = 0;
        int index = 0;
        while (index < length) {
            // 如果股票一直下跌就一直找，直到找到股票开始上涨为止
            while (index < length - 1 && prices[index] >= prices[index + 1]) {
                index++;
            }
            int min = prices[index];
            // 找到股票上涨最大值
            while (index < length - 1 && prices[index] <= prices[index + 1]) {
                index++;
            }
            // 计算上涨期间的差值，然后累加
            total += (prices[index] - min);
            index++;
        }
        return total;
    }

    // 贪心算法
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 比如a<b<c<d，因为从a到d一直是上涨的，那么最大值和最小值的差值就是d-a，也可以写成(b-a)+(c-b)+(d-c)，搞懂了这个公式所有的一切都明白了。
        // 可以想象成数组中前一个值减去后一个值，构成一个新的数组，我们只需要计算这个新数组中正数的和即可
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            // 原数组中如果后一个减去前一个是正数，说明是上涨的，
            // 我们就要累加，否则就不累加
            max += Math.max(prices[i] - prices[i - 1], 0);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxProfit2 maxProfit = new MaxProfit2();
        int[] prices = {7,1,5,3,6,4};
        int lirun = maxProfit.maxProfit3(prices);
        System.out.println(lirun);
    }

}
