package com.vishal.interviews.top100linkedquestions.easy;

import java.util.*;

public class TwoSum {

	public static void main(String[] args) {

	}

	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];

		if (nums == null || nums.length < 2) {
			return res;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i] - target)) {
				res[0] = map.get(nums[i] - target);
				res[1] = i;
				break;
			}
			map.put(nums[i], i);
		}
		return res;
	}

}
