package com.vishal.interviews.programcreek;

public class ImplementstrStr {

	public static void main(String[] args) {

	}

	public int strStr(String haystack, String needle) {

		for (int i = 0; i < haystack.length() - needle.length(); i++) {
			for (int j = 0; j <= needle.length(); j++) {
				if (j == needle.length()) {
					return i;
				}

				if (needle.charAt(j) != haystack.charAt(i + j)) {
					break;
				}
			}
		}
		return -1;
	}

}
