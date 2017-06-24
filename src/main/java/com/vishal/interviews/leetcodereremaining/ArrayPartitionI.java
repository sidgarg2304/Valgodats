package com.vishal.interviews.leetcodereremaining;

import java.util.Arrays;

public class ArrayPartitionI {

	public static void main(String[] args) {

	}

	public int arrayPairSum(int[] nums) {

		Arrays.sort(nums);
		int res = 0;
		for (int i = 0; i < nums.length; i += 2) {
			res += nums[i];
		}
		return res;
	}

}
