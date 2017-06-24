package com.vishal.interviews.programcreek;

import java.util.*;

public class SummaryRanges {

	public static void main(String[] args) {

	}

	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();

		int p = nums[0];
		for (int i = 1; i <= nums.length; i++) {
			if (i == nums.length || nums[i] - nums[i - 1] > 1) {
				addRange(res, p, nums[i - 1]);
				p = nums[i];
			}
		}
		
		return res;
	}

	void addRange(List<String> res, int l, int h) {
		if (l > h) {
			return;
		}

		if (l == h) {
			res.add("" + l);
		} else {
			res.add(l + "->" + h);
		}
	}

}
