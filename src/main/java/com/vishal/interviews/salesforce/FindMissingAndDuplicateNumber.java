package com.vishal.interviews.salesforce;

import java.util.Arrays;

/**
 * Given an array, which contains integers in the range of 1 to n. one number is
 * missing from it and one number is repeated in array. for ex -- array is
 * {1,2,3,4,4,6,7,8,9} , range given is 1- n(n=9). determine which number is
 * missing and which is repeated in array.
 *
 */
public class FindMissingAndDuplicateNumber {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(findFixedDupLoop(new int[] { 1, 2, 3, 4, 4, 6, 7, 8, 9 })));
	}

	static int[] findFixedDupLoop(int[] nums) {

		int[] res = new int[2];

		if (nums == null || nums.length <= 1) {
			return res;
		}

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				res[0] = nums[i];
				res[1] = nums[i] + 1;
				break;
			}
		}
		return res;
	}

	//Looks not possible
	// 0, 1, 2, 3, 4, 5, 6, 7, 8
	// 1, 2, 3, 4, 4, 6, 7, 8, 9
	// 1, 2, 2, 4, 5, 6, 7, 8, 9
	// 1, 2, 3, 4, 5, 6, 7, 7, 9
	static int[] findFixedDupBinarySearch(int[] nums) {

		int[] res = new int[2];

		if (nums == null || nums.length <= 1) {
			return res;
		}

		int i = 0;
		int j = nums.length - 1;
		while (i < j) {
			int m = (i + j) / 2;
			if (nums[m] != m + 1) {

			}
		}
		return res;
	}

}
