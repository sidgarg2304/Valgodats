package com.vishal.interviews.topinterviewquestions.medium;

public class DecodeWays {

	public static void main(String[] args) {

	}

	public int numDecodings(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}

		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		for (int i = 1; i <= s.length(); i++) {
			if (i > 1 && s.charAt(i - 2) != '0') {
				int sub = Integer.parseInt(s.substring(i - 2, i));
				if (sub >= 10 && sub <= 26) {
					dp[i] += dp[i - 2];
				}
			}
			if (s.charAt(i - 1) != '0') {
				dp[i] += dp[i - 1];
			}
		}

		return dp[s.length()];
	}

}
