package com.vishal.interviews.facebook.hard;

/**
 * 44. Wildcard Matching
 * 
 * 
 * Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
 *
 */
public class WildcardMatching {

	public static void main(String[] args) {

	}

	public boolean isMatch(String s, String p) {

		int i = 0;
		int j = 0;
		int starIndex = -1;
		int iIndex = -1;

		while (i < s.length()) {
			char s1 = s.charAt(i);

			if (j < p.length() && (s1 == p.charAt(j) || p.charAt(j) == '?')) {
				i++;
				j++;
			} else if (j < p.length() && p.charAt(j) == '*') {
				starIndex = j;
				iIndex = i;
				j++;
			} else if (starIndex >= 0) {
				j = starIndex + 1;
				i = iIndex + 1;
				iIndex++;
			} else {
				return false;
			}
		}
		
		while(j < p.length() && p.charAt(j) == '*'){
			j++;
		}
		
		return j == p.length();

	}

}
