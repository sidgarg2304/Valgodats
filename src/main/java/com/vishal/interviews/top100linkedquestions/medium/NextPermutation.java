package com.vishal.interviews.top100linkedquestions.medium;

public class NextPermutation {

	public static void main(String[] args) {

	}

	// 7479876
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int i = nums.length - 2;

		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}

		int j = nums.length - 1;
		while (nums[i] >= nums[j]) {
			j--;
		}

		swap(nums, i, j);

		reverse(nums, i + 1, nums.length - 1);

	}

	void reverse(int[] nums, int i, int j) {
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
