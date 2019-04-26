package com.vishal.interviews.facebook.medium;

/**
 * 33. Search in Rotated Sorted Array
 *
 *Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
 */
public class SearchinRotatedSortedArray {

	public static void main(String[] args) {

	}
	
	public int search(int[] nums, int target) {
      int i = 0;
		int j = nums.length - 1;

		while (i <= j) {
			int m = i + (j - i) / 2;

			if (nums[m] == target) {
				return m;
			}

			if (nums[m] > nums[i]) {
				if (target >= nums[i] && target < nums[m]) {
					j = m - 1;
				} else {
					i = m + 1;
				}
			} else if (nums[m] < nums[i]) {
				if (target > nums[m] && target <= nums[j]) {
					i = m + 1;
				} else {
					j = m - 1;
				}
			} else {
				i++;
			}

		}

		return -1;
  }

}
