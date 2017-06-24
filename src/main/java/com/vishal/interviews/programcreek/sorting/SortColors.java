package com.vishal.interviews.programcreek.sorting;

public class SortColors {

	public static void main(String[] args) {

	}

	public void sortColors(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int i = 0;
		int j = nums.length - 1;

		int st = 0;

		while (st <= j) {

			while (nums[st] == 2 && st < j) {
				swap(nums, st, j--);				
			}
			
			while (nums[st] == 0 && st > i) {
				swap(nums, st, i++);				
			}
			
			st++;
		}
	}

	void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}
