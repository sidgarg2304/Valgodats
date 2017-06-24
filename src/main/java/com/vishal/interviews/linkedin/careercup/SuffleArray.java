package com.vishal.interviews.linkedin.careercup;

import java.util.*;

/**
 * Shuffle a given array such that each position is equally likely.
 *
 */
public class SuffleArray {

	public static void main(String[] args) {
		suffleArray(new int[] { 1, 2, 3 });
	}

	static void suffleArray(int[] nums) {
		Random rand = new Random();
		for (int i = 0; i < nums.length; i++) {
			int randPos = rand.nextInt(i + 1);
			int temp = nums[randPos];
			nums[randPos] = nums[i];
			nums[i] = temp;
		}

		System.out.println(Arrays.toString(nums));
	}

}
