package com.vishal.interviews.facebook.easy;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPalindrome(int x) {

		if (x < 0) {
			return false;
		}

		return x == reverse(x);

	}

	int reverse(int x) {

		int res = 0;

		while (x > 0) {
			int mod = x % 10;
			res = res * 10 + mod;

			x /= 10;
		}
		return res;
	}

}
