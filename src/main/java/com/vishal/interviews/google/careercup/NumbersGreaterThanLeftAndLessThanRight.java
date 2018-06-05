package com.vishal.interviews.google.careercup;

import java.util.*;

/**
 * Second question Given an array of integers, print all the numbers that meet
 * the following requirement - when the number is greater than every number on
 * its left and smaller than every number on the right.
 *
 */
public class NumbersGreaterThanLeftAndLessThanRight {

	public static void main(String[] args) {

		System.out.println(getNumbers(new int[] { 1, 4, 6, 8, 7 }));
	}

	// 1 4 6 8 7
	static List<Integer> getNumbers(int[] nums) {
		List<Integer> res = new ArrayList<>();

		int[] maxUntilNow = new int[nums.length];
		maxUntilNow[0] = Integer.MIN_VALUE;
		for (int i = 1; i < nums.length; i++) {
			maxUntilNow[i] = Math.max(maxUntilNow[i - 1], nums[i - 1]);
		}

		int[] minFromNow = new int[nums.length];
		minFromNow[minFromNow.length - 1] = Integer.MAX_VALUE;
		for (int i = nums.length - 2; i >= 0; i--) {
			minFromNow[i] = Math.min(nums[i + 1], minFromNow[i + 1]);
		}

		System.out.println(Arrays.toString(maxUntilNow));
		System.out.println(Arrays.toString(minFromNow));

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > maxUntilNow[i] && nums[i] < minFromNow[i]) {
				res.add(nums[i]);
			}
		}
		return res;
	}

}
