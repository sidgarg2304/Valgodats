package com.vishal.interviews.nestlabs;

/**
 * Given an array of integers of length N from 1 to N-1, how would you detect a
 * single duplicate in the array?
 *
 */
public class FindTheDuplicateNumber {

	public static void main(String[] args) {

		System.out.println(findDuplicate(new int[] { 1, 2, 3, 3 })); // 3
		System.out.println(findDuplicate(new int[] { 1, 1, 2, 3 })); // 1
		System.out.println(findDuplicate(new int[] { 1, 2, 2, 3 })); // 2
		System.out.println(findDuplicate(new int[] { 2, 2, 1, 3 })); // 2
		
		System.out.println(findDuplicateWithoutModifyingArray(new int[] { 1, 2, 3, 3 })); // 3
		System.out.println(findDuplicateWithoutModifyingArray(new int[] { 1, 1, 2, 3 })); // 1
		System.out.println(findDuplicateWithoutModifyingArray(new int[] { 1, 2, 2, 3 })); // 2
		System.out.println(findDuplicateWithoutModifyingArray(new int[] { 2, 2, 1, 3 })); // 2
	}

	// 0 1 2 3 3
	// answer is 3
	public static int findDuplicate(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int p = Math.abs(nums[i]) - 1;
			if (nums[p] < 0) {
				return p + 1;
			}
			nums[p] = -nums[p];
		}
		return -1;
	}
	
	public static int findDuplicateWithoutModifyingArray(int[] nums) {

		int slow = 0;
		int fast = 0;

		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		int find = 0;
		while (find != slow) {
			find = nums[find];
			slow = nums[slow];
		}

		return find;
	}

}
