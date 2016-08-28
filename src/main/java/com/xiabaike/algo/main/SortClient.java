package com.xiabaike.algo.main;

import com.xiabaike.algo.sort.*;

public class SortClient {

	public static void main(String[] args) {
		int[] arr = {25, 11, 45, 26, 12, 78};
		// 冒泡排序
		ISort sort = new BubbleSort();
		// 选择排序
		sort = new SelectionSort();
		// 直接插入排序
		sort = new InsertSort();
		// 希尔排序
		sort = new ShellSort();
		sort.sort(arr);
		// 输出排序结果
		for(int num : arr) {
			System.out.println(num);
		}
	}
	
}
