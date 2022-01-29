package com.xiabaike.algo.leetcode.simple.math;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 输入：n = 10  输出：4  解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 输入：n = 0  输出：0
 * 输入：n = 1  输出：0
 */
public class CountPrimes {

    public int countPrimes(int n) {
        boolean[] arr = new boolean[n];
        int cnt = 0;
        for(int i = 2; i < n; i++) {
            if(arr[i]) continue;
            cnt++;
            for(int j = i; j < n; j+=i) {
                arr[j] = true;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        countPrimes.countPrimes(2);
    }

}
