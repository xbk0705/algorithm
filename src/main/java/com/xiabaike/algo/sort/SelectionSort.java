package com.xiabaike.algo.sort;

import java.util.Arrays;

/**
 * 选择排序
 * */
public class SelectionSort implements ISort{

	public void sort(int[] arr) {
		int tmp;
		// 第n轮排序过程中的较小数的下标
		int small;
		
		for(int i = 0; i < arr.length - 1; i++) {
			small = i;
			// 找出最小的数的下标
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[small]) {
					small = j;
				}
			}
			// 交换
			if(small != i) {
				tmp = arr[i];
				arr[i] = arr[small];
				arr[small] = tmp;
			}
			System.out.println(i + ":" + Arrays.toString(arr));
		}
	}

}
