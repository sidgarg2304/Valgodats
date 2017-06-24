package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;

public class FindAllDuplicatesinanArray {

	public static void main(String[] args) {

		System.out.println(findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
	}

	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return res;
		}
		for (int i = 0; i < nums.length; i++) {
			int pos = Math.abs(nums[i]) - 1;
			if (nums[pos] < 0) {
				res.add(Math.abs(nums[i]));
			} else {
				nums[pos] = -nums[pos];
			}
		}
		return res;
	}

}
