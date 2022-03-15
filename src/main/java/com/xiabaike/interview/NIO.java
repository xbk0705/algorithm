package com.xiabaike.interview;

/**
 *
 */
public class NIO {

    // 旋转后的有序数组的最小值
    //有序数组arr可能经过一次旋转，也可能没有，且数组中可能有重复的数。
    // 例如有序数组[1,2,3,4,5,6,7]，可以旋转处理成[4,5,6,7,1,2,3]。
    // 给定一个可能旋转过的数组，请你用尽快找出数组中的最小值。
    public int search(int[] nums) {

        int left  = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid != 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            // 判断哪部分是有序的
            if (nums[0] < nums[mid]) {
                // 有序
                if (nums[mid] > nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 无序
                if (nums[mid] > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        NIO nio = new NIO();
        int[] nums = {4,5,6,7,1,2,3};
        int num = nio.search(nums);
        System.out.println(num);
    }

}
