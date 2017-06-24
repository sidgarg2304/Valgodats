package com.vishal.interviews.linkedin.careercup;

import java.util.*;

/**
 * How to randomly select a number in an array? array: [15, 2, 4, 5, 1, -2, 0]
 * 
 * Follow-up: Given a second array freq where freq[i] represents the occurrence
 * of the ith number in array, how to randomly select a number in array based on
 * the frequency.
 * 
 * Extra requirement: Could you complete the selection in a single-pass(go
 * through each array only once)?
 *
 */
public class RandomNumberSelection {

	public static void main(String[] args) {

		System.out.println(randomSelectFollowup(new int[] { 1, 2, 3, 4 }, new int[] { 1, 4, 3, 2 }));
	}

	public int randomSelect(int[] nums) {
		Random rand = new Random();

		int pos = rand.nextInt(nums.length);

		return nums[pos];
	}

	public static int randomSelectFollowup(int[] nums, int[] freq) {
		Random rand = new Random();
		int[] sums = new int[nums.length];
		sums[0] = freq[0] - 1;
		for (int i = 1; i < freq.length; i++) {
			sums[i] = sums[i - 1] + freq[i];
		}

		int randPos = rand.nextInt(sums[sums.length - 1] + 1);

		System.out.println(Arrays.toString(sums) + " and rand pos is " + randPos);
		return search(nums, sums, randPos);
	}

	static int search(int[] nums, int[] sums, int val) {

		int i = 0;
		int j = sums.length - 1;
		while (i <= j) {
			int m = i + (j - i) / 2;
			if (sums[m] >= val) {
				if (m == 0 || val > sums[m - 1]) {
					return nums[m];
				} else {
					j = m - 1;
				}
			} else {
				i = m + 1;
			}
		}
		return nums[i];
	}

}
