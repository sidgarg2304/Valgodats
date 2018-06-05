package com.vishal.interviews.topinterviewquestions.easy;

public class ValidPalindrome {

	public static void main(String[] args) {

	}

	public boolean isPalindrome(String s) {

		s = s.toLowerCase();
		int i = 0;
		int j = s.length() - 1;

		while (i <= j) {

			while (i < s.length() && !isAlphaNumeric(s.charAt(i))) {
				i++;
			}

			while (j >= 0 && !isAlphaNumeric(s.charAt(j))) {
				j--;
			}

			if (i <= j) {
				if (s.charAt(i) != s.charAt(j)) {
					return false;
				}
				i++;
				j--;
			}
		}
		return true;
	}

	boolean isAlphaNumeric(char c) {
		return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
	}

}
