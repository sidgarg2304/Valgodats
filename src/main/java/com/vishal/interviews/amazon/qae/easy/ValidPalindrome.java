package com.vishal.interviews.amazon.qae.easy;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
 *
 */
public class ValidPalindrome {

	public static void main(String[] args) {

	}
	
	public boolean isPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return true;
		}
		int i = 0;
		int j = s.length() - 1;

		while (i < j) {
			while (i < s.length() && !isValid(s.charAt(i))) {
				i++;
			}

			while (j >= 0 && !isValid(s.charAt(j))) {
				j--;
			}

			if (i < s.length() && j >= 0 && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
				return false;
			}
			i++;
			j--;
		}

		return true;
	}

	static boolean isValid(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
	}

}
