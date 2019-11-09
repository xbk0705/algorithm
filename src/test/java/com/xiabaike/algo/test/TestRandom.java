package com.xiabaike.algo.test;

public class TestRandom {
	
	public static double random(double[] r) {
		double base, u, v, p, temp1, temp2, temp3;
		// 基数
		base = 256.0;
		u = 17.0;
		v = 139.0;

		// 计算总值
		temp1 = u * (r[0]) + v;
		// 计算商
		temp2 = (int) (temp1 / base);
		// 计算余数
		temp3 = temp1 - temp2 * base;
		// 更新随机种子，为下一次使用
		r[0] = temp3;
		// 随机数
		p = r[0] / base;
		return p;
	}

	public static void main(String[] args) {
		int i;
		double[] r = {5.0};
		for(i = 0; i < 100; i++) {
			System.out.printf("%10.5f\n",  random(r));
		}
		System.out.println();


		int x = 5;
		int y = 8;

		x = x ^ y;
		System.out.println(x +","+ y);
		y = x ^ y;
		System.out.println(x +","+ y);
		x = x ^ y;
		System.out.println(x +","+ y);
	}

}
