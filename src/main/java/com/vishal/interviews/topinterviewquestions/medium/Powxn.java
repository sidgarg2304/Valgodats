package com.vishal.interviews.topinterviewquestions.medium;

public class Powxn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double myPow(double x, int n) {
		double ans = 1;
		int absN = Math.abs(n);
		while (absN > 0) {
			if ((absN & 1) == 0) {
				ans *= x;
			}
			absN >>= 1;
			x *= x;
		}

		return n < 0 ? 1 / ans : ans;
	}

	public double myPowEasy(double x, int n) {
		if (n == 0) {
			return 1;
		}

		if (n < 0) {
			x = 1 / x;
			n = -n;
		}

		return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}

}
