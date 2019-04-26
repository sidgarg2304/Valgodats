package com.vishal.interviews.uber.easy;

public class ReverseInteger {

	public static void main(String[] args) {

	}

	public int reverse(int x) {

		if (x == 0) {
			return x;
		}
		boolean neg = x < 0;
		x = Math.abs(x);
		int res = 0;
		while (x > 0) {
			int m = x % 10;
			int newRes = res * 10 + m;

			if ((newRes - m) / 10 != res) {
				return 0;
			}
			res = newRes;
			x /= 10;
		}
		return neg ? -res : res;
	}

}
