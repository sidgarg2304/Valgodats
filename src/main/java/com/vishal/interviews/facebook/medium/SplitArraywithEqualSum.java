package com.vishal.interviews.facebook.medium;

import java.util.HashSet;
import java.util.Set;

public class SplitArraywithEqualSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean splitArray(int[] nums) {

		if (nums == null || nums.length < 7) {
			return false;
		}

		int[] prefixSum = new int[nums.length];
		for (int i = 1; i < prefixSum.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
		}

		for (int j = 3; j <= nums.length - 4; j++) {

			Set<Integer> set = new HashSet<>();
			for (int i = 1; i <= j - 2; i++) {
				if (prefixSum[i - 1] == prefixSum[j - 1] - prefixSum[i]) {
					set.add(prefixSum[i - 1]);
				}
			}

			for (int k = j - 2; k < nums.length - 2; k++) {
				if (prefixSum[k - 1] - prefixSum[j] == prefixSum[nums.length - 1] - prefixSum[k]) {
					if (set.contains(prefixSum[k - 1] - prefixSum[j])) {
						return true;
					}
				}
			}
		}
		return false;

	}

}
