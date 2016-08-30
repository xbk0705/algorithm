package com.xiabaike.algo.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort implements ISort{

	public void sort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	private static void quickSort(int[] arr, int left, int right){
		int t;
		int ltemp = left;
		int rtemp = right;
		// 分界值
		int fIndex = arr[(left + right)/ 2];
		while(ltemp < rtemp) {
			// 从左侧开始查找比分界值大的数
			while(arr[ltemp] < fIndex) {
				// 元素小于分界值，继续查找
				++ltemp;
			}
			// 从右侧开始查找比分界值小的数
			while(arr[rtemp] > fIndex) {
				// 元素大于分界值，继续查找
				--rtemp;	
			}
			// 如果查到的比分界值大的数的下标小于等于比分界值小的数的下标，则进行交换
			if(ltemp <= rtemp) {
				t = arr[ltemp];
				arr[ltemp] = arr[rtemp];
				arr[rtemp] = t;
				--rtemp;
				++ltemp;
			}
			if(ltemp == rtemp) {
				ltemp++;
			}
			System.out.println( Arrays.toString(arr));
			if(left < rtemp) {
				quickSort(arr, left, ltemp - 1);
			}
			if(ltemp < right) {
				quickSort(arr, rtemp + 1, right);
			}
		}
	}
}
