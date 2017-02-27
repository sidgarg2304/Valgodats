package com.vishal.algorithms.string.palindrome;

public class PalindromeAlgorithms {

	public static void main(String[] args) {

		testIsValidPalindrome();

		testShortestPalindromeAppendingStart();

		testShortestPalindromeAppendingLast();

	}

	public static void testIsValidPalindrome() {
		System.out.println("'aaca' is " + (isValidPalindrome("aaca") ? "valid" : "invalid") + " palindrome");
	}

	public static void testShortestPalindromeAppendingStart() {
		System.out.println("Shortest Palindrome by Appending any characters at Start of 'aaca' is "
				+ shortestPalindromeAppendingStart("aaca"));
		
		System.out.println("Shortest Palindrome by Appending any characters at Start of 'aacbdbc' is "
				+ shortestPalindromeAppendingStart("aacbdbc"));
		
		System.out.println("Shortest Palindrome by Appending any characters at Start of 'aabcdbc' is "
				+ shortestPalindromeAppendingStart("aabcdbc"));
		
		System.out.println("Shortest Palindrome by Appending any characters at Start of 'aacecaaa' is "
				+ shortestPalindromeAppendingStart("aacecaaa"));
	}

	public static void testShortestPalindromeAppendingLast() {
		System.out.println("Shortest Palindrome by Appending any characters at Last of 'aaca' is "
				+ shortestPalindromeAppendingLast("aaca"));
	}

	public static boolean isValidPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;

		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static String shortestPalindromeAppendingStart(String s) {
		int i = 0;
		int j = s.length() - 1;

		while (j >= 0) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
			}
			j--;
		}

		if (i == s.length()) {
			return s;
		}

		String suffix = s.substring(i);
//		System.out.println("suffix is " + suffix);
		String prefix = new StringBuilder(suffix).reverse().toString();
		String mid = shortestPalindromeAppendingStart(s.substring(0, i));
		return prefix + mid + suffix;
	}

	public static String shortestPalindromeAppendingLast(String s) {
		int i = s.length() - 1;
		int j = 0;

		while (j < s.length()) {
			if (s.charAt(i) == s.charAt(j)) {
				i--;
			}
			j++;
		}

		if (i < 0) {
			return s;
		}

		String prefix = s.substring(0, i + 1);
		String suffix = new StringBuilder(prefix).reverse().toString();
		String mid = shortestPalindromeAppendingLast(s.substring(i + 1));
		return prefix + mid + suffix;
	}

}
