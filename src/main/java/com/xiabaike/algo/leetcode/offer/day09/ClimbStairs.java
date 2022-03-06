package com.xiabaike.algo.leetcode.offer.day09;

import java.util.HashMap;
import java.util.Map;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 输入：n = 2  输出：2
 * 解释：有两种方法可以爬到楼顶。  1. 1 阶 + 1 阶   2. 2 阶
 * 输入：n = 3  输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶   2. 1 阶 + 2 阶   3. 2 阶 + 1 阶
 */
public class ClimbStairs {

    private Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        return climb(n);
    }

    public int climb(int n) {
        if (n == 1) {
            map.put(1,1);
            return 1;
        }
        if (n == 2) {
            map.put(2,2);
            return 2;
        }
        int tmp1;
        if (map.containsKey(n - 1)) {
            tmp1 = map.get(n - 1);
        } else {
            tmp1 = climb(n - 1);
            map.put(n - 1, tmp1);
        }
        int tmp2;
        if (map.containsKey(n - 2)) {
            tmp2 = map.get(n - 2);
        } else {
            tmp2 = climb(n - 2);
            map.put(n - 2, tmp2);
        }
        map.put(n, tmp1 + tmp2);
        return tmp1 + tmp2;
    }

    // 渐进时间复杂度为 O(n)
    // 渐进空间复杂度为 O(1)。
    public int climbStairs2(int n) {
        // n - 2
        int res1 = 0;
        // n - 1
        int res2 = 0;
        // n
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res1 = res2;
            res2 = res;
            res = res1 + res2;
        }
        return res;
    }


}
