package com.vishal.interviews.amazon.qae.easy;

/**
 * 80. Remove Duplicates from Sorted Array II
 * Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesfromSortedArrayII {

	public static void main(String[] args) {

		System.out.println(removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }));
	}

	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int r = 1;
		int ct = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[r++] = nums[i];
				ct = 1;
			} else {
				if (ct < 2) {
					nums[r++] = nums[i];
				}
				ct++;
			}
		}
		return r;
	}

}
