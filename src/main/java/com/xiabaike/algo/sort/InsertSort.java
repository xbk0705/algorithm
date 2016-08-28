package com.xiabaike.algo.sort;

import java.util.Arrays;

/**
 * 直接插入排序
 */
public class InsertSort implements ISort{

	public void sort(int[] arr) {
		int tmp;
		for(int i = 1; i < arr.length; i++) {
			// 待插入数据
			tmp = arr[i];
			int j;
			for(j = i - 1; j >= 0; j--) {
				// 判断是否大于tmp，大于则后移一位
				if(arr[j] > tmp) {
					arr[j+1] = arr[j];
				}else{
					break;
				}
			}
			arr[j+1] = tmp;
			System.out.println(i + ":" + Arrays.toString(arr));
		}
	}

}
