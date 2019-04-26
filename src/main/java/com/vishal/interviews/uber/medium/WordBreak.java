package com.vishal.interviews.uber.medium;

import java.util.*;

public class WordBreak {

	public static void main(String[] args) {

	}

	public boolean wordBreak(String s, List<String> wordDict) {

		if (s == null || s.length() == 0) {
			return true;
		}
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

}