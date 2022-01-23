package com.xiabaike.algo.leetcode.simple.array;

import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 输入：digits = [1,2,3]  输出：[1,2,4]  解释：输入数组表示数字 123。
 * 输入：digits = [4,3,2,1]  输出：[4,3,2,2]  解释：输入数组表示数字 4321。
 * 输入：digits = [0]  输出：[1]
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

        boolean is = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 > 9) {
                digits[i] = 0;
                is = true;
            } else {
                digits[i] = digits[i] + 1;
                is = false;
                break;
            }
        }
        if (is) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < digits.length + 1; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        }

        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
//        int[] digits = {1,2,3};
//        int[] digits = {4,3,2,1};
        int[] digits = {1,9};
        int[] result = plusOne.plusOne(digits);
        System.out.println(Arrays.toString(result));
    }


}
