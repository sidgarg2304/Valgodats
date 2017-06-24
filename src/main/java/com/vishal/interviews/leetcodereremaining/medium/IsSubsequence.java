package com.vishal.interviews.leetcodereremaining.medium;

/**
 * 392. Is Subsequence
 *
 */
public class IsSubsequence {

	public static void main(String[] args) {

	}

	public boolean isSubsequence(String s, String t) {
		if (t == null || s.length() == 0) {
			return s == null || s.length() == 0;
		}

		int tIndex = 0; // t
		int sIndex = 0;
		while (tIndex < t.length()) {
			char a = t.charAt(tIndex);
			char b = s.charAt(sIndex);

			if (b == a) {
				sIndex++;
				if (sIndex == s.length()) {
					return true;
				}
			}
			tIndex++;
		}

		return false;
	}

}
