package com.vishal.interviews.facebook.medium;

import java.util.Set;
import java.util.TreeSet;

public class ContainsDuplicateIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(nums == null || nums.length == 0 || k < 0 || t < 0) {
			return false;
		}
		
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

            set.add(val);
			if (set.size() > k) {
				set.remove((long) (nums[st++]));
			}
		}
		return false;

	}

}
