package com.vishal.interviews.top100linkedquestions.medium;

import java.util.*;

public class ThreeSum {

	public static void main(String[] args) {

	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}

			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					List<Integer> cur = new ArrayList<>();
					cur.add(nums[i]);
					cur.add(nums[j]);
					cur.add(nums[k]);
					res.add(cur);

					while (j < k && nums[j] == nums[j + 1]) {
						j++;
					}

					while (j < k && nums[k] == nums[k - 1]) {
						k--;
					}
					j++;
					k--;

				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		return res;
	}

}
