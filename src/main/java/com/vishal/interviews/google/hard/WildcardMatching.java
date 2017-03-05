package com.vishal.interviews.google.hard;

/**
 * 44. Wildcard Matching
 * 
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character.
 * 
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * 
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples: isMatch("aa","a") → false
 * 
 * isMatch("aa","aa") → true
 * 
 * isMatch("aaa","aa") → false
 * 
 * isMatch("aa", "*") → true
 * 
 * isMatch("aa", "a*") → true
 * 
 * isMatch("ab", "?*") → true
 * 
 * isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {

	public static void main(String[] args) {

	}

	/**
	 * Linear runtime and constant space solution I found this solution from
	 * http://yucoding.blogspot.com/2013/02/leetcode-question-123-wildcard-
	 * matching.html
	 * 
	 * The basic idea is to have one pointer for the string and one pointer for
	 * the pattern. This algorithm iterates at most length(string) +
	 * length(pattern) times, for each iteration, at least one pointer advance
	 * one step.
	 * 
	 * @param str
	 * @param pattern
	 * @return
	 */
	boolean comparisonConstantSpace(String str, String pattern) {
		int s = 0, p = 0, match = 0, starIdx = -1;
		while (s < str.length()) {
			// advancing both pointers
			if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
				s++;
				p++;
			}
			// * found, only advancing pattern pointer
			else if (p < pattern.length() && pattern.charAt(p) == '*') {
				starIdx = p;
				match = s;
				p++;
			}
			// last pattern pointer was *, advancing string pointer
			else if (starIdx != -1) {
				p = starIdx + 1;
				match++;
				s = match;
			}
			// current pattern pointer is not star, last patter pointer was not *
			// characters do not match
			else
				return false;
		}

		// check for remaining characters in pattern
		while (p < pattern.length() && pattern.charAt(p) == '*')
			p++;

		return p == pattern.length();
	}

	/**
	 * My java DP solution using 2D table
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatchDP(String s, String p) {
		boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
		match[s.length()][p.length()] = true;
		for (int i = p.length() - 1; i >= 0; i--) {
			if (p.charAt(i) != '*')
				break;
			else
				match[s.length()][i] = true;
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = p.length() - 1; j >= 0; j--) {
				if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
					match[i][j] = match[i + 1][j + 1];
				else if (p.charAt(j) == '*')
					match[i][j] = match[i + 1][j] || match[i][j + 1];
				else
					match[i][j] = false;
			}
		}
		return match[0][0];
	}
}
