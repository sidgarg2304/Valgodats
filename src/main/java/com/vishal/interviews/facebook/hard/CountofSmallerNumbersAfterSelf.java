package com.vishal.interviews.facebook.hard;

import java.util.ArrayList;
import java.util.List;

public class CountofSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> countSmaller(int[] nums) {

		List<Integer> res = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return res;
		}

		List<Integer> sorted = new ArrayList<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			int index = findSortedIndex(nums[i], sorted);
			res.add(0, index);
			sorted.add(index, nums[i]);
		}
		return res;
	}

	int findSortedIndex(int num, List<Integer> sorted) {

		if (sorted.size() == 0) {
			return 0;
		}

		if (num <= sorted.get(0)) {
			return 0;
		}

		if (num > sorted.get(sorted.size() - 1)) {
			return sorted.size();
		}

		int st = 0;
		int en = sorted.size() - 1;
		while (st <= en) {
			int m = st + (en - st) / 2;
			if (num > sorted.get(m)) {
				st = m + 1;
			} else {
				en = m - 1;
			}
		}
		if (num > sorted.get(st)) {
			return st + 1;
		}
		return st;
	}

}
