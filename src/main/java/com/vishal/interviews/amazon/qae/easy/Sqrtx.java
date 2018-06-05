package com.vishal.interviews.amazon.qae.easy;

public class Sqrtx {

	public static void main(String[] args) {

	}

	public int mySqrt(int x) {
		if (x == 0) {
			return 0;
		}

		int l = 1;
		int r = x / 2;

		while (l <= r) {
			int m = l + (r - l) / 2;

			if (m * m > x) {
				r = m - 1;
			} else {

				if ((m + 1) * (m + 1) > x) {
					return m;
				}

				l = m + 1;
			}
		}
		return l;
	}

}
