package com.vishal.interviews.programcreek.dynamicprogramming;

public class DecodeWays {

	public static void main(String[] args) {

	}

	public int numDecodings(String s) {
		int[] dp = new int[s.length() + 1];

		dp[0] = 1;

		dp[1] = s.charAt(0) - '0' == 0 ? 0 : 1;

		for (int i = 2; i <= s.length(); i++) {
			int two = Integer.parseInt(s.substring(i - 2, i));

			if (s.charAt(i - 1) - '0' != 0) {
				dp[i] = dp[i - 1];
			}

			if (two >= 10 && two <= 26) {
				dp[i] += dp[i - 2];
			}

		}

		return dp[s.length()];
	}

}
