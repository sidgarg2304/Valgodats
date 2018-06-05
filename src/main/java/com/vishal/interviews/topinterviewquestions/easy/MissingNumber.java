package com.vishal.interviews.topinterviewquestions.easy;

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
