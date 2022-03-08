package com.xiabaike.interview;

public class Solution {

    //
    public boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length <= 2) {
            return false;
        }

        int flag = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                flag = 1;
            }
            if (flag == 1 && arr[i] < arr[i + 1]) {
                return false;
            }
        }
        return flag == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3,4,3,2,1}; // true
//        int[] arr = {1,2,3,4,5,6,7}; // true
        boolean res = solution.validMountainArray(arr);
        System.out.println(res);

        int[] arr1 = {1,2,3,4,3,2,3}; // false
//        int[] arr = {1,2,3,4,5,6,7}; // true
        res = solution.validMountainArray(arr1);
        System.out.println(res);

        int[] arr2 = {1,2,3,4,5,6,7}; // false
        res = solution.validMountainArray(arr2);
        System.out.println(res);

        int[] arr3 = {5,4,3,2,1}; // false
        res = solution.validMountainArray(arr3);
        System.out.println(res);
    }

}
