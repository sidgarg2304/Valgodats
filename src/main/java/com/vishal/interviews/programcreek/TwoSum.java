package com.vishal.interviews.programcreek;

import java.util.*;

public class TwoSum {

	public static void main(String[] args) {

	}

	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				res[0] = map.get(target - nums[i]);
				res[1] = i;
				break;
			}
			map.put(nums[i], i);
		}
		return res;
	}

}
