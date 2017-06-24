package com.vishal.interviews.programcreek.math;

public class FactorialTrailingZeroes {

	public static void main(String[] args) {

	}

	public int trailingZeroes(int n) {
		if (n < 0) {
			return -1;
		}

		int count = 0;
		int i = 5;
		while (n / i >= 1) {
			count += n / i;
			i *= 5;
		}

		return count;
	}

}
