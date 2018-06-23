package com.vishal.interviews.salesforce;

public class MaxSubArrayXOROfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// xor of 2 same numbers is 0
	//
	// 0 xor 0 = 0
	// 1 xor 1 = 0
	// 0 xor 1 = 1
	// 1 xor 0 = 1
	int maxSubArrayXOR(int[] nums) {

		int max = nums[0];

		for (int i = 0; i < nums.length; i++) {

			int curXor = 0;
			for (int j = i; j < nums.length; j++) {
				curXor ^= nums[j];
				max = Math.max(max, curXor);
			}			
		}
		return max;

	}

}
