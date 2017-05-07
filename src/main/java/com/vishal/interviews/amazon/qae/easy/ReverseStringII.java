package com.vishal.interviews.amazon.qae.easy;

/**
 * Reverse first k characters of every 2k characters
 * 
 * abcdefg , k = 2 
 * bacdfeg
 *
 */
public class ReverseStringII {

	public static void main(String[] args) {

		System.out.println(reverse("abcdefg", 2));

	}

	static String reverse(String s, int k) {
		char[] arr = s.toCharArray();

		int i = 0;

		while (i < s.length()) {
			int j = i + k - 1;
			ReverseaString.reverse(arr, i, j);
			i += 2 * k;
		}

		return String.valueOf(arr);
	}

}
