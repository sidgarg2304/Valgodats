package com.vishal.interviews.topinterviewquestions.easy;

public class FactorialTrailingZeroes {

	public static void main(String[] args) {

	}

	public int trailingZeroes(int n) {

		int res = 0;

		int val = 5;
		while (n / val >= 1) {
			res += n / val;
			val *= 5;
		}
		return res;
	}

}
