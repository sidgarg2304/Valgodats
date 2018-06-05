package com.vishal.interviews.topinterviewquestions.easy;

import java.util.*;

public class ContainsDuplicate {

	public static void main(String[] args) {

	}

	public boolean containsDuplicate(int[] nums) {

		if (nums == null || nums.length == 0) {
			return false;
		}
		
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (!set.add(nums[i])) {
				return true;
			}
		}
		return false;
	}

}
