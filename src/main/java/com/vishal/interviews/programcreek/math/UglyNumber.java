package com.vishal.interviews.programcreek.math;

public class UglyNumber {

	public static void main(String[] args) {

		System.out.println(isUgly(30));
	}

	public static boolean isUgly(int num) {
		if (num == 0) {
			return false;
		}
		if (num == 1) {
			return true;
		}

		while (num > 0 && num % 2 == 0) {
			num /= 2;
		}

		while (num > 0 && num % 3 == 0) {
			num /= 3;
		}

		while (num > 0 && num % 5 == 0) {
			num /= 5;
		}

		return num == 1;
	}

}
