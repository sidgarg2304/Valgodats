package com.vishal.interviews.facebook.careercup;

import java.util.*;

/**
 * Given an array of task and k wait time for which a repeated task 
needs to wait k time to execute again. please rearrange the task 
sequences to minimize the total time to finish all the tasks. 
Example 
Tasks = 111222, k = 2, 
One possible task sequence is 
12_12_12, 
another possible task sequence is 21_21_21 
thus you shoud return 8 
 *
 */
public class RearrangeTasksKDistanceApart {

	public static void main(String[] args) {

		System.out.println(getMiniTime(new int[] { 1, 1, 1, 2, 2, 2 }, 2));
	}

	public static int getMiniTime(int[] nums, int k) {

		int max = nums[0];
		for (int i : nums) {
			max = Math.max(max, i);
		}

		int[] count = new int[max + 1];
		int[] validIndex = new int[max + 1];

		for (int i : nums) {
			count[i]++;
		}

		// System.out.println(Arrays.toString(count));

		int r = 0;
		int i = 0;
		List<String> res = new ArrayList<>();
		while (i < nums.length) {
			int numToPlaceAtI = getNumberToPlaceAtIndex(count, validIndex, r);
			if (numToPlaceAtI != -1) {
				count[numToPlaceAtI]--;
				validIndex[numToPlaceAtI] += k + 1;
				res.add(String.valueOf(numToPlaceAtI));
				i++;
			} else {
				res.add("-");
			}

			r++;
		}
		System.out.println(res);
		return r;
	}

	static int getNumberToPlaceAtIndex(int[] count, int[] validIndex, int index) {
		int maxCount = Integer.MIN_VALUE;
		int candIndex = -1;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0 && count[i] > maxCount && index >= validIndex[i]) {
				maxCount = count[i];
				candIndex = i;
			}
		}

		return candIndex;
	}
}
