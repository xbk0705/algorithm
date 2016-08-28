package com.xiabaike.algo.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort implements ISort{

	public void sort(int[] arr) {
		int tmp;
		for(int i = 1; i < arr.length; i++) {
			// 判断相邻两个数据的大小，并把较大的数往后冒泡
			for(int j = 0; j < arr.length - 1; j++) {
				if(arr[j] > arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
			System.out.println(i + ":" + Arrays.toString(arr));
		}
	}

}
