package com.vishal.interviews.uber.easy;

public class Sqrtx {

	public static void main(String[] args) {

	}

	public int mySqrt(int x) {

		if (x <= 1) {
			return x;
		}

		int i = 1;
		int j = x / 2;

		while (i <= j) {
			int m = i + (j - i) / 2;
			if (m < x / m) {
				if ((m + 1) > (x / (m + 1))) {
					return m;
				}
				i = m + 1;
			} else {
				j = m - 1;
			}
		}
		return i;
	}

}
