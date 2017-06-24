package com.vishal.interviews.programcreek;

public class LongestCommonPrefix {

	public static void main(String[] args) {

	}

	public String longestCommonPrefix(String[] strs) {

		if (strs == null || strs.length == 0) {
			return "";
		}
		int minLength = Integer.MAX_VALUE;
		for (String s : strs) {
			minLength = Math.min(minLength, s.length());
		}

		for (int i = 0; i < minLength; i++) {
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].charAt(i) != strs[j - 1].charAt(i)) {
					return strs[j].substring(0, i);
				}
			}
		}

		return strs[0].substring(0, minLength);
	}

}
