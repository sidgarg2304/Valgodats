package com.vishal.interviews.uber.medium;

public class SortColors {

	public static void main(String[] args) {

	}

	public void sortColors(int[] nums) {
		
		if (nums == null || nums.length == 0) {
			return;
		}

		int zeroes = 0;
		int twos = nums.length - 1;
		int i = 0;
		while (i <= twos) {
			if (nums[i] == 0) {
				swap(nums, i++, zeroes++);
			} else if (nums[i] == 2) {
				swap(nums, i++, twos--);
			} else {
				i++;
			}
		}
	}

	void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
