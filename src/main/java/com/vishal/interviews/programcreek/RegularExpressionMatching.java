package com.vishal.interviews.programcreek;

public class RegularExpressionMatching {

	public static void main(String[] args) {

	}

	public boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}

		if (p.length() == 1 || p.charAt(0) != '*') {
			if (s.length() <= 0 || (p.charAt(0) != s.charAt(0) && p.charAt(0) != '.')) {
				return false;
			} else {
				return isMatch(s.substring(1), p.substring(1));
			}
		} else {

			if (isMatch(s, p.substring(2))) {
				return true;
			}

			int i = 0;
			while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
			}

			return false;
		}
	}

}
