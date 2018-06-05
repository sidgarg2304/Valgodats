package com.vishal.interviews.top100linkedquestions.hard;

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
		for (int i = 0; i < nums.length; i++) {
			int p = findPos(sorted, nums[i]);
			res.add(0, p);
			sorted.add(p, nums[i]);
		}

		return res;
	}

	int findPos(List<Integer> sorted, int val) {
		if (sorted == null || sorted.size() == 0) {
			return 0;
		}

		int i = 0;
		int j = sorted.size() - 1;
		while (i <= j) {
			int m = i + (j - i) / 2;
			if (val >= sorted.get(m)) {
				i = m + 1;
			} else {
				j = m - 1;
			}
		}
		
		if(val > sorted.get(i)){
			return i+1;
		}
		
		
		
		return i;
	}

}
