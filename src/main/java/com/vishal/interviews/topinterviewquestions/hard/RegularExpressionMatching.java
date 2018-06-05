package com.vishal.interviews.topinterviewquestions.hard;

public class RegularExpressionMatching {

	public static void main(String[] args) {

	}

	public boolean isMatch(String s, String p) {
		if (p == null || p.length() == 0) {
			return s == null || s.length() == 0;
		}

		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.length() < 1 || (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.')) {
				return false;
			}

			return isMatch(s.substring(1), p.substring(1));
		} else {
			if (isMatch(s, p.substring(2))) {
				return true;
			}

			int idx = 0;
			while (idx < s.length() && (s.charAt(idx) == p.charAt(0) || p.charAt(0) == '.')) {
				if (isMatch(s.substring(idx+1), p.substring(2))) {
					return true;
				}
				idx++;
			}
		}
		return false;
	}

}
