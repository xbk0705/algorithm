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
			//对左边进行递归
			sort(arr, start, middle);
			//对右边进行递归
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
			//从两个数组中选取较小的数放入中间数组
			if(arr[m] < arr[n]) {
				temp[k++] = arr[m++];
			}else{
				temp[k++] = arr[n++];
			}
		}
		
		//将剩余的部分放入中间数组
		while(m <= middle) {
			temp[k++] = arr[m++];
		}
		while(n <= j) {
			temp[k++] = arr[n++];
		}
		//将中间数组复制回原数组
		while(i <= j) {
			arr[i] = temp[i++];
		}
		System.out.println(Arrays.toString(arr));
	}
}
