package com.vishal.interviews.topinterviewquestions.easy;

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

			if (m > x / m) {
				r = m - 1;
			} else {

				if ((m + 1) > x / (m + 1)) {
					return m;
				}

				l = m + 1;
			}
		}
		return l;

	}

}
