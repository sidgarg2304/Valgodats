package com.vishal.interviews.facebook.easy;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int reverse(int x) {

		boolean neg = false;
		if (x < 0) {
			neg = true;
			x = -x;
		}
		int res = 0;
		while (x > 0) {
			int mod = x % 10;
			res = res * 10 + mod;
			x /= 10;
		}
		return neg ? -res : res;
	}

}
