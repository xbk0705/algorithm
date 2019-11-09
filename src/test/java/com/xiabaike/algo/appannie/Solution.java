package com.xiabaike.algo.appannie;

public class Solution {

	// 绝对值最大，即最大值与最小值之差，求出数组的最大值和最小值即可
	public int solution(int[] A) {
		int max = A[0];
		for(int i = 1; i < A.length; i++) {
			// 比较，得出最大值
			if(max < A[i])  {
				max = A[i];
			}
			// 比较，得出最小值
			if(A[0] > A[i]) {
				A[0] = A[i];
			}
		}
		return max - A[0];
	}
	
	public static void main(String[] args) {
		int[] A = {10, -2, 44, 15, 39 ,20};
		Solution solu = new Solution();
		System.out.println(solu.solution(A));
	}
}
