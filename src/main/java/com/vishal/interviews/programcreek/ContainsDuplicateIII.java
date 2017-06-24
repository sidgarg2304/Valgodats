package com.vishal.interviews.programcreek;

import java.util.*;

/**
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the difference between nums[i] and nums[j] is at
 * most t and the difference between i and j is at most k.
 */
public class ContainsDuplicateIII {

	public static void main(String[] args) {

	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		if (nums == null || nums.length == 0) {
			return false;
		}

		TreeSet<Long> set = new TreeSet<>();
		int st = 0;
		for (int i : nums) {
			long val = (long) i;
			long left = val - t;
			long right = val + t + 1;

			Set<Long> subSet = set.subSet(left, right);

			if (subSet.size() > 0) {
				return true;
			}

			if (set.size() > k) {
				set.remove(nums[st++]);
			}
		}

		return false;
	}
}
