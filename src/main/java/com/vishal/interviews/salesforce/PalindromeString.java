package com.vishal.interviews.salesforce;

public class PalindromeString {

	public static void main(String[] args) {
		
		System.out.println(isPalindrome("abba"));
		System.out.println(isPalindrome("aba"));
		System.out.println(isPalindrome("abca"));

	}

	static boolean isPalindrome(String s) {

		int i = 0;
		int j = s.length()-1;

		while (i < j) {
			char l = s.charAt(i);
			char r = s.charAt(j);

			if (l != r) {
				return false;
			}
			i++;
			j--;
		}
		return true;

	}

}
