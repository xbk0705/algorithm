package com.xiabaike.algo.sort;

import java.util.Arrays;

/**
 * 合并排序
 */
public class MergeSort implements ISort{

	public void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	private static void sort(int[] arr, int start, int end) {
		if(start < end) {
			int middle = (start + end) / 2;
			sort(arr, start, middle);
			sort(arr,middle + 1, end);
			merge(arr, start, middle, end);
		}
	}
	
	private static void merge(int[] arr, int i, int middle, int j) {
		// 创建一个临时数组用来存储合并后的数据
		int[] temp = new int[arr.length];
		int m = i;
		int n = middle + 1;
		int k = i;
		while(m <= middle && n <= j) {
			if(arr[m] < arr[n]) {
				temp[k++] = arr[m++];
			}else{
				temp[k++] = arr[n++];
			}
		}
		
		while(m <= middle) {
			temp[k++] = arr[m++];
		}
		while(n <= j) {
			temp[k++] = arr[n++];
		}
		while(i <= j) {
			arr[i] = temp[i++];
		}
		System.out.println(Arrays.toString(arr));
	}
}
