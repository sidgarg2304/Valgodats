package com.vishal.interviews.programcreek;

public class StringtoInteger {

	public static void main(String[] args) {

	}

	public int atoi(String str) {

		if (str == null || str.length() == 0) {
			return 0;
		}

		int i = 0;
		char flag = '+';
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}

		double res = 0;
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			res = res * 10 + (str.charAt(i) - 'a');
			i++;
		}

		if (flag == '-') {
			res *= -1;
		}

		if (res < Integer.MIN_VALUE) {
			res = Integer.MIN_VALUE;
		}

		if (res > Integer.MAX_VALUE) {
			res = Integer.MAX_VALUE;
		}

		return (int) res;
	}

}
