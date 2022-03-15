package com.xiabaike.algo.leetcode.subject.mountainarray;

/**
 * 给定一个整数数组 arr，如果它是有效的山脉数组就返回true，否则返回 false。
 * 让我们回顾一下，如果 arr满足下述条件，那么它是一个山脉数组：
 * arr.length >= 3
 * 在 0 < i < arr.length - 1 条件下，存在 i 使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 *
 * 输入：arr = [3,5,5]  输出：false
 * 输入：arr = [0,3,2,1]  输出：true
 */
public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {
        int top = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }
            if (arr[i] > arr[i + 1]) {
                top = i;
                break;
            }
        }
        if (top == -1 || top == 0 || top == arr.length - 1 || arr[0] == arr[top] || arr[top] == arr[arr.length - 1]) {
            return false;
        }
        for (int i = top; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // 双指针
    public boolean validMountainArray2(int[] arr) {
        int left = 0;
        while (left + 1 < arr.length && arr[left] < arr[left + 1]) {
            left++;
        }
        int right = arr.length - 1;
        while (right >= 1 && arr[right] < arr[right - 1]) {
            right--;
        }
        return left > 0 && right < arr.length - 1 && left == right;
    }

}
