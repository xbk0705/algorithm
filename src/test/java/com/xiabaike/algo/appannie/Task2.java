package com.xiabaike.algo.appannie;

public class Task2 {

	public int solution(int[] A) {
        int[] arr = new int[A.length];
        int count = 0;
        for(int i = 0; i < A.length; i++) {
        	arr[i] = A[i] + 1;
        	while(isExist(A,arr[i])) {
        		arr[i]= arr[i] + 1;
        		count++;
        	}
        }
		return count;
    }
	
	// 判断一个数是否存在于数组A
	private static boolean isExist(int[] arr, int num) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]+1 == num) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] A = {3,6,7};
		Task2 task = new Task2();
		System.out.println(task.solution(A));
	}
}
