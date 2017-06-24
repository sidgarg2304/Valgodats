package com.vishal.interviews.programcreek;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		rotate(nums, 3);
		System.out.println(Arrays.toString(nums));
	}

	public static void rotate(int[] nums, int k) {
		if (nums == null || nums.length <= 1) {
			return;
		}

		int n = nums.length;

		if (k > n) {
			k = k % n;
		}

		reverse(nums, 0, n - k - 1);
		reverse(nums, n - k, n - 1);

		reverse(nums, 0, n - 1);
	}

	static void reverse(int[] nums, int i, int j) {
		while (i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}

}
