package com.vishal.interviews.topinterviewquestions.easy;

public class ImplementstrStr {

	public static void main(String[] args) {

	}

	public int strStr(String haystack, String needle) {

		if(haystack == null || needle == null){
			return -1;
		}
		
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			for (int j = 0; j <= needle.length(); j++) {
				if (j == needle.length()) {
					return i;
				}

				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
			}
		}
		return -1;

	}

}
