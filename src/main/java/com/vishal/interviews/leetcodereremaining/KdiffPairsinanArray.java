package com.vishal.interviews.leetcodereremaining;

import java.util.*;

public class KdiffPairsinanArray {

	public static void main(String[] args) {

	}

	public int findPairs(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 0) {
			return 0;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		int cnt = 0;
		for (int key : map.keySet()) {
			if (k == 0) {
				if (map.get(key) >= 2) {
					cnt++;
				}
			} else {
				if (map.containsKey(key + k)) {
					cnt++;
				}
			}
		}

		return cnt;
	}

}
