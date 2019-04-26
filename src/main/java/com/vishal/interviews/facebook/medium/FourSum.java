package com.vishal.interviews.facebook.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
      List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length <= 3) {
			return res;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			for (int j = i + 1; j < nums.length - 2; j++) {

				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}

				int k = j + 1;
				int l = nums.length - 1;

				while (k < l) {
					int sum = nums[i] + nums[j] + nums[k] + nums[l];

					if (sum == target) {
						List<Integer> curRes = new ArrayList<>();
						curRes.add(nums[i]);
						curRes.add(nums[j]);
						curRes.add(nums[k]);
						curRes.add(nums[l]);
						res.add(curRes);

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
		return res;
  }

}
