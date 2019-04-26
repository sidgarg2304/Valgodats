package com.vishal.interviews.uber.medium;

import java.util.*;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return res;
		}

		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			while (j < k) {
				int sum = nums[i] = nums[j] + nums[k];
				if (sum == 0) {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(nums[k]);
					res.add(temp);

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
