package com.vishal.interviews.linkedin.careercup;

public class Sqrtx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int mySqrt(int x) {

		if (x <= 1) {
			return x;
		}
		int i = 1;
		int j = x / 2;

		while (i <= j) {
			int m = i + (j - i) / 2;

			if (m > x / m) {
				j = m - 1;
			} else {

				if (m + 1 > x / m + 1) {
					return m;
				}
				i = m + 1;
			}
		}

		return i;

	}

}
