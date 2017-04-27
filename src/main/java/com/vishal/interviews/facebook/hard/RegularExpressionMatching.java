package com.vishal.interviews.facebook.hard;

/**
 * 10. Regular Expression Matching
 * 
 * Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 *
 */
public class RegularExpressionMatching {

	public static void main(String[] args) {

		System.out.println(isMatch("aa",".*"));
	}
	
	public static boolean isMatch(String s, String p) {

		if (p.length() == 0) {
			return s.length() == 0;
		}

		if (p.length() == 1 || p.charAt(1) != '*') {

			if (s.length() < 1 || (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.')) {
				return false;
			}

			return isMatch(s.substring(1), p.substring(1));
		} else {

			// ccaab c*a*b
			// caab
			// aab

			if (isMatch(s, p.substring(2))) {
				return true;
			}

			int i = 0;
			while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {				
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}

		}

		return false;

	}

}
