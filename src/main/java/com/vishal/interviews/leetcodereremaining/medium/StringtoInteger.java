package com.vishal.interviews.leetcodereremaining.medium;

public class StringtoInteger {

	public static void main(String[] args) {

		System.out.println(myAtoi("     +004500"));
	}

	public static int myAtoi(String str) {

		if (str == null || str.length() == 0) {
			return 0;
		}

		int st = 0;

		while (st < str.length() && str.charAt(st) == ' ') {
			st++;
		}

		boolean neg = str.charAt(st) == '-' ? true : false;
		if (str.charAt(st) == '+' || str.charAt(st) == '-') {
			st++;
		}

		System.out.println("processing starts at " + (str.charAt(st)));
		double res = 0;
		for (int i = st; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				int p = str.charAt(i) - '0';
				res = (res * 10) + p;
			} else {
				break;
			}
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
