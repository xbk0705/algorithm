package com.xiabaike.algo.leetcode.offer.day06;

/**
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 *
 * 输入：nums = [2,0,2,1,1,0]  输出：[0,0,1,1,2,2]
 * 输入：nums = [2,0,1]  输出：[0,1,2]
 */
public class SortColors {

    public void sortColors(int[] nums) {
        // 移动0的下标
        int index1 = 0;
        // 移动2的下标
        int index2 = nums.length - 1;
        for (int i = 0; i <= index2; i++) {
            // 当我们找到 2 时，我们需要不断地将其与 nums[index2] 进行交换，直到新的 nums[i] 不为 2。
            while (i <= index2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[index2];
                nums[index2] = temp;
                index2--;
            }
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[index1];
                nums[index1] = tmp;
                index1++;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int len = nums.length;
        int index = 0;
        // 先排序0
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
                index++;
            }
        }
        // 再排序1
        for (int i = index; i < len; i++) {
            if (nums[i] == 1) {
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
                index++;
            }
        }

    }

}
