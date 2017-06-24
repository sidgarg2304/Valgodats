package com.vishal.interviews.programcreek;

import java.util.*;

public class FourSum {

	public static void main(String[] args) {

	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums == null || nums.length == 0) {
			return result;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
				break;
			}

			if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) {
				continue;
			}

			for (int j = i + 1; j < nums.length - 2; j++) {				

				if (j > i && nums[j] == nums[j - 1]) {
					continue;
				}
				
				if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
					break;
				}

				if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target) {
					continue;
				}								

				int k = j + 1;
				int l = nums.length - 1;

				while (k < l) {
					int sum = nums[i] + nums[j] + nums[k] + nums[l];

					if (sum == target) {
						List<Integer> temp = new ArrayList<>();
						temp.add(i);
						temp.add(j);
						temp.add(k);
						temp.add(l);
						result.add(temp);

						while (k < l && nums[k] == nums[k + 1]) {
							k++;
						}

						while (k < l && nums[l] == nums[l - 1]) {
							l--;
						}

						k++;
						l--;
					} else if (sum < target) {
						k++;
					} else {
						l--;
					}
				}

			}
		}

		return result;
	}

}
