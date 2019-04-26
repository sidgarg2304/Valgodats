package com.vishal.interviews.facebook.easy;

/**
 * 268. Missing Number
 * 
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
 *
 */
public class MissingNumber {

	public static void main(String[] args) {

	}
	
	public int missingNumber(int[] nums) {
      int n = nums.length;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		int expSum = (n * (n + 1)) / 2;

		return expSum - sum;
  }

}
