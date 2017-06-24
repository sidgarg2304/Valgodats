package com.vishal.interviews.programcreek;

import java.util.*;

/**
 * Given an array of integers and an integer k, return true if and only if there
 * are two distinct indices i and j in the array such that nums[i] = nums[j] and
 * the difference between i and j is at most k.
 *
 */
public class ContainsDuplicateII {

	public static void main(String[] args) {

	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {

		if (nums == null || nums.length < 2) {
			return false;
		}

		Set<Integer> set = new HashSet<>();

		int st = 0;
		for (int i : nums) {
			if (!set.add(i)) {
				return true;
			}
			if (set.size() > k) {
				set.remove(nums[st++]);
			}
		}
		return false;
	}
}
