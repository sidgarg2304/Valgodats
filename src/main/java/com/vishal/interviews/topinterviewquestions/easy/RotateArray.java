package com.vishal.interviews.topinterviewquestions.easy;

public class RotateArray {

	public static void main(String[] args) {

	}

	public void rotate(int[] nums, int k) {

		if (nums == null || nums.length == 0) {
			return;
		}

		int n = nums.length;
		int d = (n - k % n);
		reverse(nums, 0, d - 1);
		reverse(nums, d, n - 1);
		reverse(nums, 0, n - 1);

	}

	void reverse(int[] nums, int i, int j) {

		while (i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}
}
