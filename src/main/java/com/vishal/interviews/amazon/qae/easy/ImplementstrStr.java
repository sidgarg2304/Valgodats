package com.vishal.interviews.amazon.qae.easy;

/**
 * 28. Implement strStr()
 * 
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * haystack   needle     result
 * amazon       ma    -> 1
 * google      gle    -> 2
 *
 */
public class ImplementstrStr {

	public static void main(String[] args) {

		
	}

	// amazon
	// ma
	public static int strStr(String haystack, String needle) {
		if (haystack == null || needle == null) {
			return -1;
		}

		for (int i = 0;i <= haystack.length() - needle.length(); i++) {
			for (int j = 0; j <= needle.length(); j++) {

				// we reached end of needle. so found needle
				if (j == needle.length()) {
					return i;
				}

				// i is at a position where if we start needle at i and the
				// remaining characters in needle does not fit in haystack
				if (i + j == haystack.length()) {
					return -1;
				}

				//needle's character matches in haystack starting at i
				if (needle.charAt(j) != haystack.charAt(i + j)) {
					break;
				}

			}
		}
		return -1;
	}

}
