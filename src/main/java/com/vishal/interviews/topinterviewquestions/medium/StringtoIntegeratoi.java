package com.vishal.interviews.topinterviewquestions.medium;

public class StringtoIntegeratoi {

	public static void main(String[] args) {

	}

	public int myAtoi(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}

		boolean neg = str.charAt(0) == '-' ? true : false;
		int st = 0;
		if (str.charAt(0) == '+' || str.charAt(0) == '-') {
			st++;
		}

		double res = 0;

		for (int i = st; i < str.length(); i++) {
			if (str.charAt(i) < 0 || str.charAt(i) > 9) {
				break;
			}
			int val = str.charAt(i) - '0';
			res *= 10;
			res += val;
		}

		if (neg) {
			res *= -1;
		}

		if (res > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}

		if (res < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}

		return (int) res;
	}

}
