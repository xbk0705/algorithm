package com.xiabaike.algo.leetcode.simple.array;

import java.util.Arrays;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 输入: [2,2,1]  输出: 1
 * 输入: [4,1,2,1,2]  输出: 4
 *
 * @author xiabaike
 * Created on 2022-01-21
 */
public class SingleNumber {

    // 遍历
    public int singleNumber(int[] nums) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            boolean is = false;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    is = true;
                    break;
                }
            }
            if (!is) {
                index = i;
            }
        }
        return nums[index];
    }

    // 使用异或运算，将所有值进行异或
    // 异或运算，相异为真，相同为假，所以 a^a = 0 ;0^a = a
    // 因为异或运算 满足交换律 a^b^a = a^a^b = b 所以数组经过异或运算，单独的值就剩下了
    public int singleNumber2(int[] nums) {
        int reduce = 0;
        for (int num : nums) {
            reduce =  reduce ^ num;
        }
        return reduce;
    }

    // 先排序，遇到前后相同就直接跳过，进行下一次比较， 如果不相同，则当前元素就是只出现了一次的元素
    public int singleNumber3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                i++;
            } else {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums = {4,1,2,4,2};
        int num = singleNumber.singleNumber(nums);
        System.out.println(num);

        num = singleNumber.singleNumber2(nums);
        System.out.println(num);

        num = singleNumber.singleNumber3(nums);
        System.out.println(num);
    }

}
