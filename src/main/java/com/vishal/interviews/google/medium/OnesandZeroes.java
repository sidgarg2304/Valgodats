package com.vishal.interviews.google.medium;

import java.util.Arrays;

/**
 * 474. Ones and Zeroes
 * 
 * In the computer world, use restricted resource you have to generate maximum
 * benefit is what we always want to pursue.
 * 
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the
 * other hand, there is an array with strings consisting of only 0s and 1s.
 * 
 * Now your task is to find the maximum number of strings that you can form with
 * given m 0s and n 1s. Each 0 and 1 can be used at most once.
 * 
 * Note: The given numbers of 0s and 1s will both not exceed 100 The size of
 * given string array won't exceed 600. Example 1: Input: Array = {"10", "0001",
 * "111001", "1", "0"}, m = 5, n = 3 Output: 4
 * 
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s
 * and 3 1s, which are “10,”0001”,”1”,”0” Example 2: Input: Array = {"10", "0",
 * "1"}, m = 1, n = 1 Output: 2
 * 
 * Explanation: You could form "10", but then you'd have nothing left. Better
 * form "0" and "1".
 */
public class OnesandZeroes {

	public static void main(String[] args) {

	}

	/**
	 * Java Iterative DP Solution - O(mn) Space Time Complexity: O(kl + kmn),
	 * where k is the length of input string array and l is the average length of
	 * a string within the array.
	 * 
	 * @param strs
	 * @param m
	 * @param n
	 * @return
	 */
	public int findMaxFormIterativeDP(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (String s : strs) {
			int[] count = count(s);
			for (int i = m; i >= count[0]; i--)
				for (int j = n; j >= count[1]; j--)
					dp[i][j] = Math.max(1 + dp[i - count[0]][j - count[1]], dp[i][j]);
		}
		return dp[m][n];
	}

	public int[] count(String str) {
		int[] res = new int[2];
		for (int i = 0; i < str.length(); i++)
			res[str.charAt(i) - '0']++;
		return res;
	}

	/**
	 * Java DP solution with explanation The idea is to build up the solution for
	 * 0..m zeros and 0..n ones, from only knowing 1 string, 2 strings, ..., up
	 * to n strings.
	 * 
	 * For example, for array = {"10", "0", "1"}, m = 1, n = 1.
	 * 
	 * for first string "10":
	 * 
	 * zero = 0, one = 0
	 * 
	 * zero = 1, one = 0
	 * 
	 * zero = 0, one = 1
	 * 
	 * zero = 1, one = 1, can form "10" [+1]
	 * 
	 * continue on the second string "0", with previous knowledge of string "10":
	 * 
	 * zero = 0, one = 0
	 * 
	 * zero = 1, one = 0, can form "0" [+1]
	 * 
	 * zero = 0, one = 1
	 * 
	 * zero = 1, one = 1, can form "0" [+1] or 1 string ("10"), known from
	 * previous string continue on the last string "1", with previous knowledge
	 * of strings "10" and "0":
	 * 
	 * zero = 0, one = 0
	 * 
	 * zero = 1, one = 0, can't form "1", but we know it can form 1 string ("0")
	 * from previous set of strings
	 * 
	 * zero = 0, one = 1, can form "1" (+1)
	 * 
	 * zero = 1, one = 1, (can form "1" and 1 more string ("0") with zero = 1,
	 * one = 0, known from previous set of strings) or (1 string ("10"), known
	 * from previous set of strings)
	 * 
	 * Hence, at the end, we know that with zero = 1, one = 1, with string "10",
	 * "0", and "1", the maximum number of strings we can form is 2.
	 * 
	 * @param strs
	 * @param m
	 * @param n
	 * @return
	 */

	public int findMaxFormDP(String[] strs, int m, int n) {
		int[][] max = new int[m + 1][n + 1];
		for (int i = 0; i < strs.length; i++) {
			String str = strs[i];

			int neededZero = 0;
			int neededOne = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '0') {
					neededZero++;
				} else {
					neededOne++;
				}
			}

			int[][] newMax = new int[m + 1][n + 1];

			for (int zero = 0; zero <= m; zero++) {
				for (int one = 0; one <= n; one++) {
					if (zero >= neededZero && one >= neededOne) {
						int zeroLeft = zero - neededZero;
						int oneLeft = one - neededOne;
						newMax[zero][one] = Math.max(1 + max[zeroLeft][oneLeft], max[zero][one]);
					} else {
						newMax[zero][one] = max[zero][one];
					}
				}
			}

			max = newMax;
		}
		return max[m][n];
	}

	/**
	 * 0-1 knapsack detailed explanation. This problem is a typical 0-1 knapsack
	 * problem, we need to pick several strings in provided strings to get the
	 * maximum number of strings using limited number 0 and 1. We can create a
	 * three dimensional array, in which dp[i][j][k] means the maximum number of
	 * strings we can get from the first i argument strs using limited j number
	 * of '0's and k number of '1's.
	 * 
	 * For dp[i][j][k], we can get it by fetching the current string i or
	 * discarding the current string, which would result in dp[i][j][k] =
	 * dp[i-1][j-numOfZero(strs[i])][i-numOfOnes(strs[i])] and dp[i][j][k] =
	 * dp[i-1][j][k]; We only need to treat the larger one in it as the largest
	 * number for dp[i][j][k].
	 * 
	 * talking is cheap:
	 * 
	 * @param strs
	 * @param m
	 * @param n
	 * @return
	 */
	public int findMaxFormKnapSack(String[] strs, int m, int n) {
		int l = strs.length;
		int[][][] dp = new int[l + 1][m + 1][n + 1];

		for (int i = 0; i < l + 1; i++) {
			int[] nums = new int[] { 0, 0 };
			if (i > 0) {
				nums = calculate(strs[i - 1]);
			}
			for (int j = 0; j < m + 1; j++) {
				for (int k = 0; k < n + 1; k++) {
					if (i == 0) {
						dp[i][j][k] = 0;
					} else if (j >= nums[0] && k >= nums[1]) {
						dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - nums[0]][k - nums[1]] + 1);
					} else {
						dp[i][j][k] = dp[i - 1][j][k];
					}
				}
			}
		}

		return dp[l][m][n];
	}

	private int[] calculate(String str) {
		int[] res = new int[2];
		Arrays.fill(res, 0);

		for (char ch : str.toCharArray()) {
			if (ch == '0') {
				res[0]++;
			} else if (ch == '1') {
				res[1]++;
			}
		}

		return res;
	}

	/**
	 * By the way, 0-1 knapsack we cannot decrease the time complexity, but we
	 * can decrease the space complexity from ijk to j*k
	 * 
	 */

	public int findMaxFormKnapSackDecreaseSpace(String[] strs, int m, int n) {
		int l = strs.length;
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			Arrays.fill(dp[i], 0);
		}

		int[] nums = new int[] { 0, 0 };
		for (String str : strs) {
			nums = calculate1(str);
			for (int j = m; j >= nums[0]; j--) {
				for (int k = n; k >= nums[1]; k--) {
					if (j >= nums[0] && k >= nums[1]) {
						dp[j][k] = Math.max(dp[j][k], dp[j - nums[0]][k - nums[1]] + 1);
					} else {
						dp[j][k] = dp[j][k];
					}
				}
			}
		}

		return dp[m][n];
	}

	private int[] calculate1(String str) {
		int[] res = new int[2];
		Arrays.fill(res, 0);

		for (char ch : str.toCharArray()) {
			if (ch == '0') {
				res[0]++;
			} else if (ch == '1') {
				res[1]++;
			}
		}

		return res;
	}
}
