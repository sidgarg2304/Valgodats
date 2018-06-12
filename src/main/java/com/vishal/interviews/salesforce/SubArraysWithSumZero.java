package com.vishal.interviews.salesforce;

import java.util.*;

/**
 * Given an array containing positive and negative numbers, return all possible
 * sub arrays whose sum is zero
 *
 */
public class SubArraysWithSumZero {

	public static void main(String[] args) {

	}

	public static List<int[]> subArraysWithSumZero(int[] nums) {

		List<int[]> res = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return res;
		}

		Map<Integer, List<Integer>> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			if (sum == 0) {
				res.add(new int[] { i, i });
			}
			if (map.containsKey(sum)) {
				List<Integer> prevIndexes = new ArrayList<>();
				for (int j : prevIndexes) {
					res.add(new int[] { j, i });
				}
			} else {
				map.put(sum, new ArrayList<>());
			}
			map.get(sum).add(i);

		}
		return res;
	}

}
