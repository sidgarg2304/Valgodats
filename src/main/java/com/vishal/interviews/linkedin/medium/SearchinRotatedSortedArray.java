package com.vishal.interviews.linkedin.medium;

/**
 * 33. Search in Rotated Sorted Array
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 *
 */
public class SearchinRotatedSortedArray {

	public static void main(String[] args) {

	}
	
	//2 4 5 6 7 0 1 
	//7 0 1 2 4 5 6
	//search for 7
	static int search(int[] nums, int target) {

		int st = 0;
		int en = nums.length - 1;

		while (st < en) {
			int mid = (st + en) / 2; // 6
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] > nums[st]) {
				// left part is sorted
				if (target < nums[mid] && target >= nums[st]) {
					en = mid - 1;
				} else {
					st = mid + 1;
				}

			} else if (nums[mid] < nums[st]) {
				// right part is sorted
				if (target > nums[mid] && target <= nums[en]) {
					st = mid + 1;
				} else {
					en = mid - 1;
				}
			} else {
				//duplicates scenario
				//nums[mid] == nums[st] and not equal to target..skip st
				st++;
			}
		}

		return -1;
	}

}
