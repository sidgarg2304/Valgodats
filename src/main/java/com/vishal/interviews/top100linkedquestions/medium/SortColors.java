package com.vishal.interviews.top100linkedquestions.medium;

public class SortColors {

	public static void main(String[] args) {

	}

	public void sortColors(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int i = 0;
		int k = 0;
		int j = nums.length - 1;
		while (k <= j) {
			if (nums[k] == 0) {
				swap(nums, i++, k++);
			} else if (nums[k] == 2) {
				swap(nums, j--, k);
			} else {
				k++;
			}
		}
	}

	void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
