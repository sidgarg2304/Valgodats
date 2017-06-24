package com.vishal.interviews.linkedin.careercup;

/**
 * Given a string , " This is a test" reverse it: " tset a si siht" Do this
 * recursively.
 *
 */
public class ReverseAStringRecursively {

	public static void main(String[] args) {

		System.out.println(reverse("This is a test"));
	}

	static String reverse(String s) {
		if (s == null || s.length() <= 1) {
			return s.toLowerCase();
		}

		return "" + Character.toLowerCase(s.charAt(s.length() - 1)) + reverse(s.substring(0, s.length() - 1));
	}

}
