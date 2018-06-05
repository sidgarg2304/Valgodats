package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class MissingRanges {

	public static void main(String[] args) {

	}

	/**
	 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return
	 * ["2", "4->49", "51->74", "76->99"].
	 */

	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {

		List<String> res = new ArrayList<>();

		for (int i = 0; i <= nums.length; i++) {
			int l = i >= 1 ? nums[i - 1] + 1 : lower;
			int h = i < nums.length ? nums[i] - 1 : upper;
			addRange(nums, l, h, res);
		}
		return res;
	}

	static void addRange(int[] nums, int l, int h, List<String> res) {
		if (l > h) {
			return;
		}

		if (l == h) {
			res.add(String.valueOf(nums[l]));
		} else {
			res.add(nums[l] + "->" + nums[h]);
		}
	}

}
