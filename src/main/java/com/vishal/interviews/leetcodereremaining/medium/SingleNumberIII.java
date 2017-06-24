package com.vishal.interviews.leetcodereremaining.medium;

/**
 * 260. Single Number III
 * 
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 *
 */
public class SingleNumberIII {

	//
	public static void main(String[] args) {

	}

	public int[] singleNumber(int[] nums) {

		int diff = 0;
		for (int i : nums) {
			diff ^= i;
		}

		diff = diff & ~(diff - 1);

		int[] res = new int[2];
		for (int i : nums) {
			if ((i & diff) == 0) {
				res[0] ^= i;
			} else {
				res[1] ^= i;
			}
		}

		return res;
	}

}
