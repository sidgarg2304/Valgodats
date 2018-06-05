package com.vishal.interviews.netflix.medium;

/**
 * Calculate the no of valid BST that can be formed from [1,...N] numbers?
 *
 */
public class UniqueBinarySearchTrees {

	public static void main(String[] args) {

	}

	int uniqueBSTs(int n) {
		if (n < 0) {
			return 0;
		}

		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}

		return dp[n];
	}

}
