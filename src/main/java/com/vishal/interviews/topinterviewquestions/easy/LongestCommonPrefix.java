package com.vishal.interviews.topinterviewquestions.easy;

public class LongestCommonPrefix {

	public static void main(String[] args) {

	}

	public String longestCommonPrefix(String[] strs) {

		if (strs == null || strs.length == 0) {
			return "";
		}
		int minLen = strs[0].length();
		for (int i = 1; i < strs.length; i++) {
			minLen = Math.min(minLen, strs[i].length());
		}
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < minLen; i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (c != strs[j].charAt(i)) {
					return res.toString();
				}
			}
			res.append(c);
		}
		return res.toString();

	}

}
