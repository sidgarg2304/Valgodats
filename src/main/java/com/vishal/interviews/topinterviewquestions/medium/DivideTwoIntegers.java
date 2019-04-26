package com.vishal.interviews.topinterviewquestions.medium;

public class DivideTwoIntegers {

	public static void main(String[] args) {

	}

	// 15/3
	//

	public int divide(int dividend, int divisor) {

		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}

		if (divisor == -1 && dividend == Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}

		int sign = ((dividend > 0) ^ (divisor > 0)) ? -1 : 1;
		int res = 1;

		int num = Math.abs(dividend);
		int den = Math.abs(divisor);

		while (den <= num) {
			int val = 1;
			int d = den;
			while(num - d >= 0){
				d <<= 1;
				val <<= 1;
			}
			
			res += val;
			num -= d;
			
		}

		return res * sign;
	}

}
