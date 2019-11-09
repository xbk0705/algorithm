package com.xiabaike.algo.appannie;

public class Task {
	
	public int solution(int[] A) {
		// 要求的两部分差的最大值的绝对值
		int max = 0;
		// 前面部分的最大值
		int before = 0;
		// 后面部分的最大值
		int after = 0;
		int temp;
		for(int i = 0; i < A.length - 1; i++) {
			before = max(A, i, i);
			after = max(A, i+1, A.length);
			temp = Math.abs(before - after);
			if(max < temp){
				max = temp;
			}
		}
		return max;
    }

	private static int max(int[] arr, int start, int end){
		int max = arr[start];
		int length = end - start;
		for(int i = start+1; i < length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] A = {4, 3, 2, 5, 1, 1};
		Task task = new Task();
		System.out.println(task.solution(A));
	}
}
