package com.vishal.interviews.programcreek.math;

public class DivideTwoIntegers {

	public static void main(String[] args) {

		System.out.println(divide(15, 3));
	}

	public static int divide(int dividend, int divisor) {
		// dividend = 15
		// divisor = 3

		if (divisor == 0)
			return Integer.MAX_VALUE;

		if (divisor == -1 && dividend == Integer.MIN_VALUE)
			return Integer.MAX_VALUE;

		int sign = ((dividend > 0) ^ (divisor > 0)) ? -1 : 1;

		long lDividend = Math.abs((long) dividend);
		long lDivisor = Math.abs((long) divisor);

		int res = 0;
//		while (lDividend >= lDivisor) {
			long val = 1;
			long div = lDivisor;

			while (lDividend - div >= 0) {
				div <<= 1;
				val <<= 1;
			}
			div >>= 1;
			val >>= 1;

			res += val;
			lDividend -= div;
//		}

		return res * sign;

	}

}
