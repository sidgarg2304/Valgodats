package com.vishal.interviews.google.medium;

/**
 * 583. Delete Operation for Two Strings
 * 
 * Given two words word1 and word2, find the minimum number of steps required to
 * make word1 and word2 the same, where in each step you can delete one
 * character in either string.
 * 
 * Example 1: Input: "sea", "eat" Output: 2 Explanation: You need one step to
 * make "sea" to "ea" and another step to make "eat" to "ea".
 */
public class DeleteOperationforTwoStrings {

	public static void main(String[] args) {

	}

	public int minDistance(String word1, String word2) {

		int[][] dp = new int[word1.length() + 1][word2.length() + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				char c1 = word1.charAt(i - 1);
				char c2 = word2.charAt(j - 1);

				if (c1 == c2) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		int longestCommonSequence = dp[word1.length()][word2.length()];

		return word1.length() - longestCommonSequence + word2.length() - longestCommonSequence;
	}

}
