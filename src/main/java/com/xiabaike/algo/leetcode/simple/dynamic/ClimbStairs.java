package com.xiabaike.algo.leetcode.simple.dynamic;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 输入：n = 2  输出：2
 * 输入：n = 3  输出：3
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs2(int n) {
        return Fibonacci(n, 1, 1);
    }

    public static int Fibonacci(int n, int a, int b) {
        if (n <= 1)
            return b;
        return Fibonacci(n - 1, b, a + b);
    }

}
