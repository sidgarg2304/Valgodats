package com.vishal.interviews.programcreek.dynamicprogramming;

import java.util.*;

public class WordBreak {

	public static void main(String[] args) {

	}

	// leetcode
	public boolean wordBreak(String s, List<String> wordDict) {

		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (wordDict.contains(s.substring(j, i)) && dp[j]) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[s.length()];
	}

}
