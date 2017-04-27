package com.vishal.interviews.facebook.medium;

/**
 * 75. Sort Colors
 * 
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
 *
 */
public class SortColors {

	public static void main(String[] args) {

	}

	static void sortColors(int[] nums) {

		int first = 0;
		int second = nums.length - 1;

		int i = 0;
		while (i <= second) {
			while (nums[i] == 0 && i > first) {
				swap(nums, i, first++);
			}
			while (nums[i] == 2 && i < second) {
				swap(nums, i, second--);
			}
			i++;
		}
	}

	static void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
