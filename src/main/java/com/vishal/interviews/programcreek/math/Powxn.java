package com.vishal.interviews.programcreek.math;

public class Powxn {

	public static void main(String[] args) {

	}

	double myPow(int x, int n) {
		if (x == 0) {
			return 1;
		}

		if (x < 0) {
			x = -x;
			n = 1 / n;
		}

		return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}

}
