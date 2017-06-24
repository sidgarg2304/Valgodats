package com.vishal.interviews.facebook.careercup;

import java.util.*;

public class SubsetsOfGivenSumAndSize {

	public static void main(String[] args) {

		System.out.println(combinationSum(new int[] { -3, 4, 2, 0, 1 }, 3, 3));
	}

	public static List<List<Integer>> combinationSum(int[] nums, int target, int k) {
		List<List<Integer>> res = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - target) && i - map.get(sum - target) == k) {
				int st = map.get(sum - target) + 1;
				List<Integer> temp = new ArrayList<>();
				for (int r = st; r <= i; r++) {
					temp.add(nums[r]);
				}
				res.add(temp);
			}
			map.put(sum, i);
		}
		return res;
	}

}
