package com.vishal.interviews.topinterviewquestions.hard;

import java.util.*;

public class CountofSmallerNumbersAfterSelf {

	public static void main(String[] args) {

	}

	public List<Integer> countSmaller(int[] nums) {

		List<Integer> res = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return res;
		}

		List<Integer> sorted = new ArrayList<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			int index = findIndex(nums[i], sorted);
			res.add(0, index);
			sorted.add(index, nums[i]);
		}
		return res;
	}

	int findIndex(int val, List<Integer> sorted) {
		if (sorted == null || sorted.size() == 0) {
			return 0;
		}

		if (val <= sorted.get(0)) {
			return 0;
		}

		int st = 0;
		int en = sorted.size() - 1;

		while (st <= en) {
			int m = st + (en - st) / 2;
			if (val > sorted.get(m)) {
				st = m + 1;
			} else {
				en = m - 1;
			}
		}

		if (val > sorted.get(st)) {
			return st + 1;
		}
		return st;
	}

}
