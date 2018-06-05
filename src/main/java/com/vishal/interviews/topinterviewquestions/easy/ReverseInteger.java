package com.vishal.interviews.topinterviewquestions.easy;

public class ReverseInteger {

	public static void main(String[] args) {

		System.out.println(reverse(-123));
	}

	public static int reverse(int x) {

		boolean neg = x < 0;
		if (neg) {
			x = -x;
		}
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

		if (neg) {
			res = -res;
		}
		return res;
	}

}
