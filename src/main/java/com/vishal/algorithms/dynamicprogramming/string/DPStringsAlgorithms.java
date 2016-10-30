package com.vishal.algorithms.dynamicprogramming.string;

public class DPStringsAlgorithms {

	public static void main(String[] args) {
		testEditDistance();
		testNumDistinctSubSequencesOfSub();

	}

	public static void testEditDistance() {
		System.out.println("We need to perform " + editDistance("azced", "abcdef") + " to form azced from abcdef");
	}

	public static void testNumDistinctSubSequencesOfSub() {
		System.out.println("Number of distinct sub sequences of 'rabbit' in 'rabbbit' is "
				+ numDistinctSubSequencesOfSub("rabbbit", "rabbit"));
	}

	public static int fib(int n) {
		return fib(n - 1) + fib(n - 2);
	}

	/**
	 * Transform s2 to s1
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static int editDistance(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = i;
		}

		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = i;
		}

		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					dp[i + 1][j + 1] = 1 + Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j]));
				}
			}
		}

		printDPMatrixAndStrings(s1, s2, dp);

		System.out.println("To Transform '" + s2 + "' to '" + s1 + "' we need to perform the following operations");
		// back trace the operations from this matrix
		int i = s1.length();
		int j = s2.length();

		while (i > 0 && j > 0) {
			// we did not perform any operation. just move diagonally back
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				i -= 1;
				j -= 1;
			} else {
				// check in which direction we came from
				int top = dp[i - 1][j];
				int left = dp[i][j - 1];
				int diag = dp[i - 1][j - 1];
				if (top < left && top < diag) {
					System.out.println("added character " + s2.charAt(j - 1) + " at position " + (j - 1) + " of " + s2);
					i -= 1;
				} else if (left < top && left < diag) {
					System.out.println("deleted character " + s2.charAt(j - 1) + " at position " + (j - 1) + " of " + s2);
					j -= 1;
				} else {
					System.out.println("repalced character " + s2.charAt(j - 1) + " with " + s1.charAt(i - 1)
							+ " at position " + (j - 1) + " of " + s2);
					i -= 1;
					j -= 1;
				}
			}
		}

		return dp[s1.length()][s2.length()];
	}

	public static int numDistinctSubSequencesOfSub(String s, String sub) {
		int[][] dp = new int[s.length() + 1][sub.length() + 1];

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s.charAt(i - 1) == sub.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		printDPMatrixAndStrings(s, sub, dp);

		return dp[s.length()][sub.length()];
	}

	public static void printDPMatrixAndStrings(String s1, String s2, int[][] dp) {
		System.out.println("  ");
		System.out.print("  ");
		for (int i = 0; i < s2.length(); i++) {
			System.out.print(s2.charAt(i) + " ");
		}
		System.out.println();
		System.out.print(" ");
		for (int i = 0; i < dp.length; i++) {

			System.out.print((i > 0) ? (s1.charAt(i - 1) + " ") : " ");

			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}		
	}

}
