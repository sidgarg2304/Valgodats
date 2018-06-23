package com.vishal.interviews.salesforce;

public class Powxn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static double myPow(int x, int n) {

		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			x = 1 / x;
			n = -n;
		}

		if (n % 2 == 0) {
			return myPow(x * x, n / 2);
		} else {
			return x * myPow(x * x, n / 2);
		}
	}

}
