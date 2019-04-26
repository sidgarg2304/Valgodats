package com.vishal.interviews.facebook.medium;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 2345
	// 2354

	// 2354
	// 2453 -> 2435
	//

	// 5 4 3 2 1
	public void nextPermutation(int[] nums) {

		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i < 0) {
			reverse(nums, 0, nums.length - 1);
			return;
		}

		int j = nums.length - 1;
		while (j > i && nums[j] <= nums[i]) {
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
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
