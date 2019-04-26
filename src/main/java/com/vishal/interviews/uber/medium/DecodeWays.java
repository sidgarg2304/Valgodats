package com.vishal.interviews.uber.medium;

public class DecodeWays {

	public static void main(String[] args) {

	}

	public int numDecodings(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) != '0' ? 1 : 0;

		for (int i = 2; i <= s.length(); i++) {
			if (s.charAt(i - 1) != '0') {
				dp[i] += dp[i - 1];
			}

			if (s.charAt(i - 2) != '0') {
				int val = Integer.parseInt(s.substring(i - 2, i));
				if (val >= 10 && val <= 26) {
					dp[i] += dp[i - 2];
				}
			}
		}
		return dp[s.length()];
	}

}
