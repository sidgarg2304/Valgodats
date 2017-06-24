package com.vishal.interviews.facebook.careercup;

public class DivideTwoIntegers {

	public static void main(String[] args) {

		System.out.println(divideTwoIntegers(20, 3));
	}

	static int divideTwoIntegers(int dividend, int divisor) {

		int res = 0;

		while (dividend >= divisor) {
			int cnt = 1;
			int div = divisor;

			while (dividend - div >= 0) {
				cnt <<= 1;
				div <<= 1;
			}

			cnt >>= 1;
			div >>= 1;

			res += cnt;

			dividend -= div;
		}
		return res;
	}

}
