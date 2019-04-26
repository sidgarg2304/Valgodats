package com.vishal.interviews.facebook.hard;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minDistance(String word1, String word2) {

		int[][] dp = new int[word1.length() + 1][word2.length() + 1];

		dp[0][0] = 0;
		for (int i = 1; i <= word1.length(); i++) {
			dp[i][0] = dp[i - 1][0] + 1;
		}

		for (int j = 1; j <= word2.length(); j++) {
			dp[0][j] = dp[0][j-1] + 1;
		}

		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				char a = word1.charAt(i - 1);
				char b = word2.charAt(j - 1);

				if (a == b) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
				}
			}
		}
		return dp[word1.length()][word2.length()];
	}

}
