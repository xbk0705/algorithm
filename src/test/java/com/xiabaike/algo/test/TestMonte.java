package com.xiabaike.algo.test;

public class TestMonte {

	public static void  montePI(int n){
		double PI;
		double x, y;
		int i, sum = 0;
		for(i = 1; i < n; i++) {
			x = Math.random();
			y = Math.random();
			if((x * x + y * y) <= 1) {
				sum++;
			}
		}
		PI = 4.0 * sum / n;
		System.out.println(PI);
	}
	
	public static void main(String[] args) {
		montePI(100000000);
	}
}
