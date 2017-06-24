package com.vishal.interviews.programcreek;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 *
 */
public class FindTheDuplicateNumber {

	public static void main(String[] args) {

		System.out.println(findDuplicate(new int[] { 1, 2, 3, 3, 4, 5 }));
		System.out.println(findDuplicate(new int[] { 1, 2, 3, 5, 4, 5 }));
		System.out.println(findDuplicate(new int[] { 1, 2, 1, 3, 4, 5 }));
		System.out.println(findDuplicate(new int[] { 4, 1, 3, 2, 5, 2 }));

	}

	public static int findDuplicate(int[] nums) {

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
