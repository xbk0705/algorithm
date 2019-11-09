package com.xiabaike.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author xiabaike
 * @Date 2019/3/7 23:46
 */
public class Solution {


    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }
        return index;
    }


    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     * 输入: 123
     * 输出: 321
     */
    public static int reverse(int x) {

        long result = 0;

        while(x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }

        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)result;
    }

    /**
     * 回文数
     */
    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int reverse = reverse(x);
        if(reverse == x) {
            return true;
        }
        return false;
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int num = 0;
        boolean flag = true;
        for(int i = 0; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            if(map.get(ch) < map.get( s.charAt(i+1))) {
                int n = map.get( s.charAt(i+1)) - map.get(ch);
                num = num + n;
                i++;
                if(i == s.length() - 1) {
                    flag = false;
                }
            } else {
                num += map.get(ch);
            }
        }
        if(flag) {
            num += map.get(s.charAt(s.length() - 1));
        }
        return num;
    }

    public static String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        String str = strs[0];
        int length = str.length();
        for(int i = 1; i < strs.length; i++) {
            if(strs[i].length() < length) {
                str = strs[i];
                length = strs[i].length();
            }
        }

        char[] lowChar;
        String low = str;
        for(int i = 0; i < strs.length; i++) {
            lowChar = low.toCharArray();
            char[] nowChar = strs[i].toCharArray();
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < lowChar.length; j++) {
                if(lowChar[j] == nowChar[j]) {
                    sb.append(lowChar[j]);
                } else {
                    break;
                }
            }
            low = sb.toString();
        }

        return low;
    }

    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4
     * 你不需要考虑数组中超出新长度后面的元素。
     */
    public static int removeDuplicates(int[] nums) {

        int length = nums.length;
        for(int i = 0; i < length - 1; i++) {

            for(int j = i + 1; j < length; j++) {
                if(nums[i] == nums[j]) {
                    int tmp = nums[j];
                    nums[j] = nums[length - 1];
                    nums[length - 1] = tmp;
                    length--;
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int length = removeDuplicates(nums);

        System.out.println(length);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
}
