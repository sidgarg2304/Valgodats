package com.vishal.interviews.facebook.medium;

import java.util.Arrays;

/**
 * 80. Remove Duplicates from Sorted Array II
 * 
 * Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums 
being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 *
 */
public class RemoveDuplicatesfromSortedArrayII {

	public static void main(String[] args) {

		int[] nums = new int[] { 1,2};
		System.out.println(removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}

	public static int removeDuplicates(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int res = 0;
		int ct = 1;
		nums[res] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] == nums[i]) {
				ct++;
				if (ct <= 2) {
					res++;
					nums[res] = nums[i];					
				}				
			} else {
				ct = 1;
				res++;
				nums[res] = nums[i];
			}
		}
		return res+1;

	}

}
