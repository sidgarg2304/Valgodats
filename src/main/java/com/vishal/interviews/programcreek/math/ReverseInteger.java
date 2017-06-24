package com.vishal.interviews.programcreek.math;

public class ReverseInteger {

	public static void main(String[] args) {

		System.out.println(reverse(1));
	}

	// 124

	public static int reverse(int x) {

		boolean flag = false;
		flag = x < 0 ? true : false;
		int rev = 0;

		if (flag) {
			x *= -1;
		}

		while (x > 0) {
			int mod = x % 10;
			int newRev = rev * 10 + mod;
			//To prevent overflow
			if ((newRev - mod) / 10 != rev) {
				return 0;
			}

			rev = newRev;
			x = x / 10;
		}

		if (flag) {
			rev *= -1;
		}

		return rev;
	}

}
