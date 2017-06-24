package com.vishal.interviews.programcreek;

/**
 * For example, "Red rum, sir, is murder" is a palindrome, while
 * "Programcreek is awesome" is not.
 *
 */
public class ValidPalindrome {

	public static void main(String[] args) {

	}

	public boolean isPalindrome(String s) {

		int i = 0;
		int j = s.length() - 1;

		s = s.toLowerCase().trim();

		while (i < j) {

			while (i < s.length() && !isValid(s.charAt(i))) {
				i++;
			}

			while (j >= 0 && !isValid(s.charAt(j))) {
				j--;
			}

			if (i <= j && s.charAt(i) != s.charAt(j)) {
				return false;
			}

			i++;
			j--;
		}

		return true;
	}

	boolean isValid(char c) {
		if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
			return true;
		}

		return false;
	}

}
