package com.vishal.interviews.facebook.medium;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int divide(int dividend, int divisor) {

		if (dividend == 0) {
			return 0;
		}

		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}

		if (divisor == -1 && dividend == Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}

		int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;

		long num = Math.abs((long) dividend); // 10010
		long den = Math.abs((long) divisor); // 00011

		int res = 0;
		while (num >= den) {

			long d = den;
			long val = 1;

			while (num - d >= 0) {
				d <<= 1;
				val <<= 1;
			}
			d >>= 1;
			val >>= 1;

			res += val;
			num -= d;
		}

		return res * sign;

	}

}
