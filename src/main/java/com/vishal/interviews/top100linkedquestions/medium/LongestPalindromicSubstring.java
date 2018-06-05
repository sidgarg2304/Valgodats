package com.vishal.interviews.top100linkedquestions.medium;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {

	}

	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		int res = 0;
		String result = "";
		boolean[][] dp = new boolean[s.length()][s.length()];
		for (int l = 1; l <= s.length(); l++) {
			for (int i = 0; i <= s.length() - l; i++) {
				int j = i + l - 1;
				if (l == 1) {
					dp[i][j] = true;
				} else if (l == 2) {
					dp[i][j] = s.charAt(i) == s.charAt(j);
				} else {
					dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
				}

				if (dp[i][j]) {
					res = Math.max(res, l);
					if (result.length() < res) {
						result = s.substring(i, j + 1);
					}
				}
			}
		}
		return result;
	}

}
