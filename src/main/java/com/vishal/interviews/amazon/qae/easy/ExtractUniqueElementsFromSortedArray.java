package com.vishal.interviews.amazon.qae.easy;

import java.util.Arrays;

/**
 * Write a code for extracting unique elements from a sorted list of array. e.g.
 * (1, 1, 3, 3, 3, 5, 5, 5, 9, 9, 9, 9) -> (1, 3, 5, 9).
 *
 */
public class ExtractUniqueElementsFromSortedArray {

	public static void main(String[] args) {

		System.out
				.println("output is " + Arrays.toString(extractUnique(new int[] { 1, 1, 3, 3, 3, 5, 5, 5, 5, 9, 9, 9 })));
	}

	static int[] extractUnique(int[] nums) {
		int i = 1;
		int k = 1;

		int ct = 1;
		while (i < nums.length) {
			if (nums[i] != nums[i - 1]) {
				nums[k++] = nums[i];
				ct++;
			}
			i++;
		}
		
		//copy result
		int[] res = new int[ct];
		for (int r = 0; r < ct; r++) {
			res[r] = nums[r];
		}		
		return res;
	}

}
