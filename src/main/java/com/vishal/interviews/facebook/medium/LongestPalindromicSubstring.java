package com.vishal.interviews.facebook.medium;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {

	}

	public String longestPalindrome(String s) {

		if (s == null || s.length() <= 1) {
			return s;
		}

		String res = "";
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
				
				if(dp[i][j]){
					String sub = s.substring(i, j+1);
					if(sub.length() > res.length()){
						res = sub;
					}
				}
			}
		}
		return res;	
    }

}
