package com.vishal.interviews.facebook.easy;

/**
 * 28. Implement strStr()
 * 
 * Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 */
public class ImplementstrStr {

	public static void main(String[] args) {

	}
	
	public int strStr(String haystack, String needle) {
      if (haystack == null || needle == null || haystack.length() < needle.length()) {
			return -1;
		}

		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			int j = 0;
			while (j <= needle.length()) {
				if (j == needle.length()) {
					return i;
				}

				char h = haystack.charAt(i + j);
				char n = needle.charAt(j);
				if (h == n) {
					j++;
				} else {
					break;
				}
			}
		}
		return -1;
  }

}
