package com.vishal.interviews.leetcodereremaining;

public class NumberofSegmentsinaString {

	public static void main(String[] args) {

	}

	public int countSegments(String s) {

		int res = 0;
		boolean found = false;
		for (int i = 0; i <= s.length(); i++) {
			if (i == s.length() || s.charAt(i) == ' ') {
				if (found) {
					res++;
				}
				found = false;
			} else {
				found = true;
			}
		}
		return res;
	}

}
