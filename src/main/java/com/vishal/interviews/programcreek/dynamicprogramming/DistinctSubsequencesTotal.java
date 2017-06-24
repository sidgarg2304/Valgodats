package com.vishal.interviews.programcreek.dynamicprogramming;

public class DistinctSubsequencesTotal {

	public static void main(String[] args) {

	}

	public static int numDistinctSubSequencesOfSub(String s, String sub) {
		int[][] dp = new int[s.length() + 1][sub.length() + 1];

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				char a = s.charAt(i - 1);
				char b = sub.charAt(j - 1);

				if (a == b) {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[s.length()][sub.length()];
	}

}
