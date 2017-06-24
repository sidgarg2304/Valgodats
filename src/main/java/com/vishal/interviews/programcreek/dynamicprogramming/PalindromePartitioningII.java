package com.vishal.interviews.programcreek.dynamicprogramming;

public class PalindromePartitioningII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minCut(String s) {

		if (s == null || s.length() <= 1) {
			return 0;
		}
		int[][] dp = new int[s.length()][s.length()];

		for (int l = 2; l <= s.length(); l++) {
			for (int i = 0; i <= s.length() - l; i++) {
				int j = i + l - 1;

				if (l == 2) {
					if (s.charAt(i) != s.charAt(j)) {
						dp[i][j] = 1;
					}
				} else {
					if (s.charAt(i) != s.charAt(j) || dp[i + 1][j - 1] != 0) {
						dp[i][j] = Integer.MAX_VALUE;
						for (int k = i; k < j; k++) {
							dp[i][j] = Math.min(dp[i][j], 1 + dp[i][k] + dp[k + 1][j]);
						}
					}
				}
			}
		}

		return dp[s.length() - 1][s.length() - 1];
	}

}
