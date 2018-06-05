package com.vishal.interviews.facebook.careercup;

import java.util.*;

/**
 * Given m 0 and n 1, count the total number of permutations where two 1 cannot
 * be adjacent
 *
 */
public class NonAdjacentOnesAndTwosPermutations {

	public static void main(String[] args) {

		System.out.println(count(2, 2));
	}

	// 0 0 1 1
	// 0 1 0 1
	// 1 0 1 0
	public static int count(int m, int n) {

		Map<String, Integer> dp = new HashMap<>();
		int r = dfs(m, n, false, dp);

		// System.out.println(dp);
		return r;
	}

	static int dfs(int zeroes, int ones, boolean prevOne, Map<String, Integer> dp) {

		if (zeroes < 0 || ones < 0) {
			return 0;
		}
		String key = "z " + zeroes + " o " + ones + " p " + prevOne;
		if (dp.containsKey(key)) {
			return dp.get(key);
		}
		if (zeroes == 0 && ones == 0) {
			dp.put(key, 1);
			return 1;
		}

		int res = 0;
		if (!prevOne) {
			res += dfs(zeroes, ones - 1, true, dp);
		}

		res += dfs(zeroes - 1, ones, false, dp);

		dp.put(key, res);
		return res;
	}
}
