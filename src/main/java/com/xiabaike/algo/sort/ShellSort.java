package com.xiabaike.algo.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort implements ISort{

	public void sort(int[] arr) {
		// i表示希尔排序中的第n/2+1个元素（或者n/4+1）
		// j表示希尔排序中从0到n/2的元素（n/4）
		// r表示希尔排序中n/2+1或者n/4+1的值
		int i, j, r, tmp;
		// 划组排序
		for(r = arr.length / 2; r >= 1; r = r / 2) {
			for(i = r; i < arr.length; i++) {
				tmp = arr[i];
				j = i - r;
				// 一轮排序
				while(j >= 0 && tmp < arr[j]) {
					arr[j+r] = arr[j];
					j -= r;
				}
				arr[j+r] = tmp;
			}
			System.out.println(i + ":" + Arrays.toString(arr));
		}
	}

}
