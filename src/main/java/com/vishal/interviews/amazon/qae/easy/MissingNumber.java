package com.vishal.interviews.amazon.qae.easy;

/**
 * Here is a big list of numbers from 1 to 1000, but one is missing -- how will
 * you efficiently find the one that is missing
 *
 */
public class MissingNumber {

	public static void main(String[] args) {

	}

	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	static int missingNumber(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		int expectedSum = (1000 * (1000 + 1)) / 2;

		return expectedSum - sum;
	}

}
