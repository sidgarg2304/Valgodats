package com.vishal.interviews.leetcodereremaining;

import java.util.*;

public class LongestHarmoniousSubsequence {

	public static void main(String[] args) {

	}

	public int findLHS(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		int res = 0;
		for (int i : nums) {
			if (map.containsKey(i + 1)) {
				res = Math.max(res, map.get(i) + map.get(i + 1));
			}
		}

		return res;
	}
}
