package com.vishal.interviews.facebook.easy;

public class LongestCommonPrefix {

	public static void main(String[] args) {

	}

	public String longestCommonPrefix(String[] strs) {

		if(strs == null || strs.length == 0){
			return "";
		}
		int minLen = strs[0].length();
		for (String s : strs) {
			minLen = Math.min(s.length(), minLen);
		}

		StringBuilder sb = new StringBuilder();
		Outer: for (int i = 0; i < minLen; i++) {
			char c = strs[0].charAt(i);
			for (String s : strs) {
				if (s.charAt(i) != c) {
					break Outer;
				} 								
			}
			sb.append(c);
		}
		return sb.toString();
	}

}
