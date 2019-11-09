package com.xiabaike.algo;

import org.junit.Test;

/**
 * @Author xiabaike
 * @Date 2019/3/10 17:44
 */
public class TestSort {

    public static void main(String[] args) {
        int num = 2;
        System.out.println(3 << 3);
        System.out.println(16 >> 3);
        System.out.println(-16 >> 3);
        System.out.println(Integer.MAX_VALUE);
        long nums = 2147483647L  / 4L;
        System.out.println(nums);
        System.out.println(-16 >>> 3);
    }

    @Test
    public void testBubble() {
        int[] arr = {25, 45, 78, 11, 26, 12};

        int tmp;
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length-1; j++) {
                if(arr[j+1] < arr[j]) {
                    tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        // 输出排序结果
        for(int num : arr) {
            System.out.print(num);
            System.out.print("   ");
        }

    }

    @Test
    public void testSelect() {
        int[] arr = {25, 45, 78, 11, 26, 12};


        int tmp;
        int small;
        for(int i = 0; i < arr.length - 1; i++) {
            small = i;
            for(int j = i + 1; j < arr.length; j++) {

                if(arr[small] > arr[j]) {
                    small = j;
                }
            }

            if(small != i) {
                tmp = arr[i];
                arr[i] = arr[small];
                arr[small] = tmp;
            }
        }

        // 输出排序结果
        for(int num : arr) {
            System.out.print(num);
            System.out.print("   ");
        }
    }

    @Test
    public void testQuick() {
        int[] arr = {25, 45, 78, 11, 26, 12};


    }

    private void quick(int[] arr, int left, int right) {

        int ltmp = left;
        int rtmp = right;
        int mibble = arr[(ltmp + rtmp) / 2];

        while(ltmp < rtmp) {

            while(arr[ltmp] < mibble) {
                ltmp++;
            }

            while(mibble < arr[rtmp]) {
                rtmp--;
            }

            if(ltmp <= rtmp) {
                int t = arr[ltmp];
                arr[ltmp] = arr[rtmp];
                arr[rtmp] = t;
                ltmp++;
                rtmp--;
            }

            if(left < rtmp) {
                quick(arr, left, ltmp - 1);
            }

            if(ltmp < right) {
                quick(arr, rtmp + 1, right);
            }
        }
    }

}
