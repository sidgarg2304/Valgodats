package com.vishal.interviews.programcreek;

public class ShortestPalindrome {

	public static void main(String[] args) {

	}

	public String shortestPalindrome(String s) {

		if (s == null || s.length() == 0) {
			return s;
		}

		int j = s.length() - 1;
		int i = 0;
		while (j >= 0) {
			if (s.charAt(j) == s.charAt(i)) {
				i++;
			}
			j--;
		}

		if (j == s.length()) {
			return s;
		}

		String suffix = s.substring(i);
		String prefix = new StringBuilder(suffix).reverse().toString();
		return prefix + shortestPalindrome(s.substring(0, i)) + suffix;
	}

}
