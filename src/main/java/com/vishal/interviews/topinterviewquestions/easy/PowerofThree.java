package com.vishal.interviews.topinterviewquestions.easy;

public class PowerofThree {

	public static void main(String[] args) {

	}

	public boolean isPowerOfThree(int n) {
		if (n <= 0) {
			return false;
		}

		while (n > 0 && n % 3 == 0) {
			n /= 3;
		}

		return n == 1;
	}

}
