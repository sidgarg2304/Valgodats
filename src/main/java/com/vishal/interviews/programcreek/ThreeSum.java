package com.vishal.interviews.programcreek;

import java.util.*;

public class ThreeSum {

	public static void main(String[] args) {

	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums == null || nums.length == 0) {
			return result;
		}
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int j = i + 1;
			int k = nums.length - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];

				if (sum == 0) {
					List<Integer> temp = new ArrayList<>();
					temp.add(i);
					temp.add(j);
					temp.add(k);

					while (j < k && nums[j] == nums[j + 1]) {
						j++;
					}

					while (k > j && nums[k] == nums[k - 1]) {
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

		return result;
	}

}
