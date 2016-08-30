package com.xiabaike.algo.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort implements ISort{

	public void sort(int[] arr) {
		int i,j,k,t;
		int n = arr.length;
		// 将 arr[0, n-1] 建成大根堆
		for(i = n/2-1; i >= 0; i--) {
			// 第 i个节点有右子树
			while(2*i+1 < n) {
				j = 2*i+1;
				if((j+1) < n) {
					// 右左子树小于右子树，则需要比较右子树
					if(arr[j] < arr[j+1]) {
						// 序号增加1，指向右子树
						j++;
					}
				}
				// 比较 i 与 j 为序号的数据
				if(arr[i] < arr[j]) {
					// 交换数据
					t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;
					// 堆被破坏，需要重新调整
					i = j;
				}else{
					// 比较左右子树节点均大则堆未破坏，不再需要调整
					break;
				}
			}
		}
		
		System.out.println("源数据构成的堆："+ Arrays.toString(arr));
		
		for(i = n-1; i > 0; i--) {
			// 与第i个记录交换
			t = arr[0];
			arr[0] = arr[i];
			arr[i] = t;
			k = 0;
			// 第 i 个节点有右子树
			while(2*k+1 < i) {
				j = 2*k + 1;
				if((j + 1) < i) {
					// 右左子树小于右子树，则需要比较右子树
					if(arr[j] < arr[j+1]) {
						// 序号增加1，指向右子树
						j++;
					}
				}
				// 比较 i 与 j 为序号的数据
				if(arr[k] < arr[j]) {
					// 交换数据
					t = arr[k];
					arr[k] = arr[j];
					arr[j] = t;
					// 堆被破坏，需要重新调整
					k = j;
				}else{
					// 比较左右子树节点均大则堆未破坏，不再需要调整
					break;
				}
			}
			System.out.println("第"+(n-i)+"步排序结果：" + Arrays.toString(arr));
		}
	}
}
