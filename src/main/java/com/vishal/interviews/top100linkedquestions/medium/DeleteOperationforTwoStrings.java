package com.vishal.interviews.top100linkedquestions.medium;

public class DeleteOperationforTwoStrings {

	public static void main(String[] args) {

	}

	public int minDistance(String word1, String word2) {
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				char c1 = word1.charAt(i-1);
				char c2 = word2.charAt(j-1);
				if(c1 == c2){
					dp[i][j] = dp[i-1][j-1] + 1;
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		int longCommonSeq = dp[word1.length()][word2.length()];
		return word1.length() - longCommonSeq + word2.length() - longCommonSeq;
	}
}
